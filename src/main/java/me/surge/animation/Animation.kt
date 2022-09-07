package me.surge.animation

/**
 * @author Surge
 * @since 26/07/2022
 */
open class Animation(val length: () -> Float, val initialState: Boolean, val easing: () -> Easing) {

    // Time since last state update
    private var lastMillis: Long = 0L

    // Current state of the animation
    // True = Expanding / Expanded
    // False = Contracting / Collapsed
    var state: Boolean = initialState
        set(value) {
            lastMillis = if (!value) {
                System.currentTimeMillis() - ((1 - getLinearFactor()) * length.invoke().toLong()).toLong()
            } else {
                System.currentTimeMillis() - (getLinearFactor() * length.invoke().toLong()).toLong()
            }

            field = value
        }

    /**
     * Constructor that does not take suppliers as parameters
     */
    constructor(length: Float, initialState: Boolean, easing: Easing) : this({ length }, initialState, { easing })

    /**
     * Constructor that only takes one supplier (length) and an immutable easing
     */
    constructor(length: () -> Float, initialState: Boolean, easing: Easing) : this(length, initialState, { easing })

    /**
     * Constructor that only takes one supplier (easing) and an immutable length
     */
    constructor(length: Float, initialState: Boolean, easing: () -> Easing) : this({ length }, initialState, easing)

    /**
     * Gets the animation factor (value between 0 and 1)
     *
     * @return The animation factor
     */
    open fun getAnimationFactor(): Double = if (state) {
        easing.invoke().ease(((System.currentTimeMillis() - lastMillis.toDouble()) / length.invoke().toDouble()).coerceIn(0.0, 1.0))
    } else {
        easing.invoke().ease((1 - (System.currentTimeMillis() - lastMillis.toDouble()) / length.invoke().toDouble()).coerceIn(0.0, 1.0))
    }

    /**
     * Resets the animation to the original constructor parameters
     */
    fun resetToDefault() {
        state = initialState

        lastMillis = if (initialState) {
            System.currentTimeMillis() - ((1 - getLinearFactor()) * length.invoke().toLong()).toLong()
        } else {
            System.currentTimeMillis() - (getLinearFactor() * length.invoke().toLong()).toLong()
        }
    }

    /**
     * For internal use only!
     */
    private fun getLinearFactor(): Double = if (!state) { (1 - (System.currentTimeMillis() - lastMillis.toDouble()) / length.invoke().toDouble()).coerceIn(0.0, 1.0) } else { ((System.currentTimeMillis() - lastMillis.toDouble()) / length.invoke().toDouble()).coerceIn(0.0, 1.0) }

}