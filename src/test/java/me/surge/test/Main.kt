package me.surge.test

import me.surge.animation.Animation
import me.surge.animation.BoundedAnimation
import me.surge.animation.ColourAnimation
import me.surge.animation.Easing
import java.awt.Color

/**
 * @author Surge
 * @since 06/09/2022
 */
fun main() {
    /************** NORMAL **************/
    println("NORMAL ANIMATION")

    // Create animation object
    val animation = Animation({ 200f }, false, { Easing.LINEAR })

    // Set animation state
    animation.state = true

    // Get and print animation factor
    while (animation.getAnimationFactor() < 1.0) {
        println(animation.getAnimationFactor())
    }



    /************** BOUNDED **************/
    println("BOUNDED ANIMATION")

    // Create bounded animation object
    val bounded = BoundedAnimation(5f, 20f, 200f, false, Easing.LINEAR)

    // Set animation state
    bounded.state = true

    // Get and print animation factor
    while (bounded.getAnimationFactor() < bounded.maximum) {
        println(bounded.getAnimationFactor())
    }



    /************** COLOUR **************/
    println("COLOUR ANIMATION")

    // Create bounded animation object
    val colourAnimation = ColourAnimation(Color.RED, Color.BLUE, 200f, false, Easing.LINEAR)

    // Set animation state
    colourAnimation.state = true

    // Get and print animation factor
    while (colourAnimation.getColour() != colourAnimation.to) {
        // Colour
        val colour = colourAnimation.getColour()

        println("R ${colour.red} G ${colour.green} B ${colour.blue} A ${colour.alpha}")
    }
}