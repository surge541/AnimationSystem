package me.surge.animation

import java.util.function.Supplier

/**
 * @author Surge
 * @since 26/07/2022
 */
class Animation(private val length: Supplier<Float>, private val initialState: Boolean, val easing: Supplier<Easing>) {

    // Time since last state update
    private var lastMillis: Long = 0L

    // Current state of the animation
    // True = Expanding / Expanded
    // False = Contracting / Collapsed
    var state: Boolean = initialState
        set(value) {
            lastMillis = if (!value) {
                System.currentTimeMillis() - ((1 - getLinearFactor()) * length.get().toLong()).toLong()
            } else {
                System.currentTimeMillis() - (getLinearFactor() * length.get().toLong()).toLong()
            }

            field = value
        }

    /**
     * Gets the animation factor (value between 0 and 1)
     *
     * @return The animation factor
     */
    fun getAnimationFactor(): Double = if (state) {
        easing.get().ease(clamp((System.currentTimeMillis() - lastMillis.toDouble()) / length.get().toDouble(), 0.0, 1.0))
    } else {
        easing.get().ease(clamp(1 - (System.currentTimeMillis() - lastMillis.toDouble()) / length.get().toDouble(), 0.0, 1.0))
    }

    /**
     * Resets the animation to the original constructor parameters
     */
    fun resetToDefault() {
        state = initialState

        lastMillis = if (initialState) {
            System.currentTimeMillis() - ((1 - getLinearFactor()) * length.get().toLong()).toLong()
        } else {
            System.currentTimeMillis() - (getLinearFactor() * length.get().toLong()).toLong()
        }
    }

    /**
     * For internal use only!
     */
    private fun getLinearFactor(): Double = if (!state) clamp(
        1 - (System.currentTimeMillis() - lastMillis.toDouble()) / length.get().toDouble(),
        0.0,
        1.0
    ) else clamp((System.currentTimeMillis() - lastMillis.toDouble()) / length.get().toDouble(), 0.0, 1.0)

    private fun clamp(value: Double, min: Double, max: Double): Double {
        return if (value < min) {
            min
        } else if (value > max) {
            max
        } else {
            value
        }
    }

}