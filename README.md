# Live Football World Cup Score Board

This library allows to create a score board for tracking live football matches for Kotlin.

Simple example:
```kotlin
fun main() {
    val scoreBoard = FScoreBoard()
    val matchKey = MatchKey("Canada", "Mexico")
    scoreBoard.startMatch(matchKey)
   
    val runningMatches = scoreBoard.getMatches()
}
```

## Using
To use the library, you need to perform the following steps.

1. Run the `publishToMavenLocal` gradle task.
   This will build and install the `scoreboard` library.
1. Add `mavenLocal` to repositories in your project, and then add the dependency for this library.
   For example (gradle): `implementation("com.sportradar.scoreboard:scoreboard:1.0-SNAPSHOT")`.

