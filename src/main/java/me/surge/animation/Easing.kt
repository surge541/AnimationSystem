package me.surge.animation

import java.lang.Math.pow
import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos

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
    SINE_IN({ input -> 1 - cos((input * PI) / 2) }),

    /**
     * Speed gradually decreases
     */
    SINE_OUT({ input -> sin((input * PI) / 2) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    SINE_IN_OUT({ input -> -(cos(PI * input) - 1) / 2 }),

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
    QUAD_IN({ input -> input * input }),

    /**
     * Speed gradually decreases
     */
    QUAD_OUT({ input -> 1 - (1 - input) * (1 - input) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    QUAD_IN_OUT({ input -> if (input < 0.5) 2.0 * input * input else 1 - (-2 * input + 2).pow(2.0) / 2 }),

    /**
     * Speed gradually increases
     */
    QUART_IN({ input -> input * input * input * input }),

    /**
     * Speed gradually decreases
     */
    QUART_OUT({ input -> 1 - (1 - input).pow(4.0) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    QUART_IN_OUT({ input -> if (input < 0.5) 8 * input * input * input * input else 1 - (-2 * input + 2).pow(4.0) / 2 }),

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
    CIRC_IN({ input -> 1 - sqrt(1 - input.pow(2.0)) }),

    /**
     * Speed gradually decreases
     */
    CIRC_OUT({ input -> sqrt(1 - (input - 1).pow(2)) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    CIRC_IN_OUT({ input -> if (input < 0.5) (1 - sqrt(1 - (2 * input).pow(2.0))) / 2 else (sqrt(1 - (-2 * input + 2).pow(2.0)) + 1) / 2 }),

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
    EXPO_IN_OUT({ input -> if (input == 0.0) 0.0 else if (input == 1.0) 1.0 else if (input < 0.5) 2.0.pow(20 * input - 10) / 2.0 else (2 - 2.0.pow(-20 * input + 10)) / 2.0 }),

    /**
     * Speed gradually increases
     */
    ELASTIC_IN({ input -> if (input == 0.0) 0.0 else if (input == 1.0) 1.0 else (-2.0).pow(10 * input - 10) * sin((input * 10 - 10.75) * ((2 * PI) / 3)) }),

    /**
     * Speed gradually decreases
     */
    ELASTIC_OUT({ input -> if (input == 0.0) 0.0 else if (input == 1.0) 1.0 else 2.0.pow(-10 * input) * sin((input * 10 - 0.75) * ((2 * PI) / 3)) + 1 }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    ELASTIC_IN_OUT({ input -> if (input == 0.0) 0.0 else if (input == 1.0) 1.0 else if (input < 0.5) -(2.0.pow(20 * input - 10) * sin((20 * input - 11.125) * ((2 * Math.PI) / 4.5))) / 2 else (2.0.pow(-20 * input + 10) * sin((20 * input - 11.125) * ((2 * Math.PI) / 4.5))) / 2 + 1 }),

    /**
     * Speed gradually increases
     */
    BACK_IN({ input -> 2.70158 + 1 * input * input * input - 1.70158 * input * input }),

    /**
     * Speed gradually decreases
     */
    BACK_OUT({ input -> 1 + 2.70158 * (input - 1).pow(3.0) + 1.70158 * (input - 1).pow(2.0) }),

    /**
     * Speed gradually increases until halfway and then decreases
     */
    BACK_IN_OUT({ input -> if (input < 0.5) ((2 * input).pow(2.0) * ((2.5949095 + 1) * 2 * input - 2.5949095)) / 2 else ((2 * input - 2).pow(2.0) * ((2.5949095 + 1) * (input * 2 - 2) + 2.5949095) + 2) / 2 });

    /**
     * Apply the easing function to the input
     *
     * @param input The linear animation that we want to ease
     * @return The eased animation
     */
    open fun ease(input: Double) = easeFunction.invoke(input)

}