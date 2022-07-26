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
  
<dependency>
    <groupId>com.github.Wolfsurge</groupId>
    <artifactId>AnimationSystem</artifactId>
    <version>Tag</version>
</dependency>
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
