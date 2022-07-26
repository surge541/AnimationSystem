package me.surge.animation

import kotlin.math.pow

/**
 * @author Surge
 * @since 26/07/22
 */
enum class Easing(private val easeFunction: (Double) -> Double) {

    /**
     * No easing
     */
    LINEAR({ input -> input }),

    /**
     * Speed gradually increases
     */
    CUBIC_IN({ input -> input * input * input }),

    /**
     * Speed gradually decreases
     */
    CUBIC_OUT({ input -> 1 - (1 - input).pow(3.0) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    CUBIC_IN_OUT({ input -> if (input < 0.5) 4 * input * input * input else 1 - (-2 * input + 2).pow(3.0) / 2 }),

    /**
     * Speed gradually increases
     */
    QUINT_IN({ input -> input * input * input * input * input }),

    /**
     * Speed gradually decreases
     */
    QUINT_OUT({ input -> 1 - (1 - input).pow(5.0) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    QUINT_IN_OUT({ input -> if (input < 0.5) 16 * input * input * input * input * input else 1 - (-2 * input + 2).pow(5.0) / 2 }),

    /**
     * Speed gradually increases
     */
    EXPO_IN({ input -> if (input == 0.0) 0.0 else 2.0.pow(10.0 * input - 10.0) }),

    /**
     * Speed gradually decreases
     */
    EXPO_OUT({ input -> if (input == 1.0) 1.0 else 1 - 2.0.pow(-10 * input) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    EXPO_IN_OUT({ input -> if (input == 0.0) 0.0 else if (input == 1.0) 1.0 else if (input < 0.5) 2.0.pow(20 * input - 10) / 2.0 else (2 - 2.0.pow(-20 * input + 10)) / 2.0 });

    /**
     * Apply the easing function to the input
     *
     * @param input The linear animation that we want to ease
     * @return The eased animation
     */
    open fun ease(input: Double) = easeFunction.invoke(input)

}