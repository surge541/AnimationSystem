package me.surge.animation

/**
 * @author Surge
 * @since 06/09/2022
 *
 * I was debating whether to have @param minimum and @param maximum as suppliers, but there would be too many constructors to make :P
 */
class BoundedAnimation(var minimum: Float, var maximum: Float, length: () -> Float, initialState: Boolean, easing: () -> Easing) : Animation(length, initialState, easing) {

    /********************* CONSTRUCTORS *********************/

    init {
        // Just in case??
        if (minimum > maximum) {
            val min = minimum
            val max = maximum

            minimum = max
            maximum = min
        }
    }

    /**
     * Constructor that does not take suppliers as parameters
     */
    constructor(minimum: Float, maximum: Float, length: Float, initialState: Boolean, easing: Easing) : this(minimum, maximum, { length }, initialState, { easing })

    /**
     * Constructor that only takes one supplier (length) and an immutable easing
     */
    constructor(minimum: Float, maximum: Float, length: () -> Float, initialState: Boolean, easing: Easing) : this(minimum, maximum, length, initialState, { easing })

    /**
     * Constructor that only takes one supplier (easing) and an immutable length
     */
    constructor(minimum: Float, maximum: Float, length: Float, initialState: Boolean, easing: () -> Easing) : this(minimum, maximum, { length }, initialState, easing)

    override fun getAnimationFactor(): Double {
        return minimum + ((maximum - minimum) * super.getAnimationFactor())
    }

}