# AnimationSystem
Simple animation system written in Kotlin.

## Add to projects
### Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Wolfsurge:AnimationSystem:1.0'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
  
<dependencies>
    <dependency>
        <groupId>com.github.Wolfsurge</groupId>
        <artifactId>AnimationSystem</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

## Usage
Create an animation object by instantiating the Animation class:

```kotlin
val animation: Animation = Animation( { 200f }, false, { Easing.LINEAR } )
```

The constructor takes in three parameters:<br>
`length` A supplier that provides the length (duration) of the animation.<br>
`initialState` A boolean that determines whether the animation should start expanded or closed.<br>
`easing` A supplier that provides the easing we want to use for the animation.

You can set the state of the animation at any time, by simply setting the `state` variable.<br>
```kotlin
animation.state = true
```

You can get the current value of the animation by calling `getAnimationFactor()`<br>
This method returns a double between 0 and 1, representing the current progress of the animation.

When applying this, it should be used in a similar way to this:
```kotlin
val y = 100.0 * animation.getAnimationFactor()
```

The `resetToDefault` method instantly resets the animation to its original state.


