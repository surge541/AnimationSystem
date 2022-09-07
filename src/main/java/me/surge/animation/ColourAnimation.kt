package me.surge.animation

import java.awt.Color

/**
 * @author Surge
 * @since 06/09/2022
 *
 * I'M SORRY AMERICANS BUT LIKE I'M WELSH SO I'M SPELLING IT WITH A U
 * at least I didn't spell it the Welsh way (lliw)
 */
class ColourAnimation(val from: Color, val to: Color, length: () -> Float, initialState: Boolean, easing: () -> Easing) : Animation(length, initialState, easing) {

    /********************* CONSTRUCTORS *********************/

    /**
     * Constructor that does not take suppliers as parameters
     */
    constructor(from: Color, to: Color, length: Float, initialState: Boolean, easing: Easing) : this(from, to, { length }, initialState, { easing })

    /**
     * Constructor that only takes one supplier (length) and an immutable easing
     */
    constructor(from: Color, to: Color, length: () -> Float, initialState: Boolean, easing: Easing) : this(from, to, length, initialState, { easing })

    /**
     * Constructor that only takes one supplier (easing) and an immutable length
     */
    constructor(from: Color, to: Color, length: Float, initialState: Boolean, easing: () -> Easing) : this(from, to, { length }, initialState, easing)

    /**
     * Gets the transitioned colour
     */
    fun getColour(): Color {
        val factor = getAnimationFactor()

        return Color(
            (from.red + (to.red - from.red) * factor).toInt(),
            (from.green + (to.green - from.green) * factor).toInt(),
            (from.blue + (to.blue - from.blue) * factor).toInt(),
            (from.alpha + (to.alpha - from.alpha) * factor).toInt()
        )
    }

}