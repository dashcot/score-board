package com.sportradar.scoreboard

import java.time.Instant

class Match(
    val matchKey: MatchKey,
    val creationTime: Instant,
    var homeTeamScore: Int = 0,
    var awayTeamScore: Int = 0
) {

    fun updateScore(homeTeamScore:Int, awayTeamScore: Int) {
        this.homeTeamScore = homeTeamScore
        this.awayTeamScore = awayTeamScore
    }

}

fun Match.toMatchInfo() = MatchInfo(
    matchKey = matchKey,
    homeTeamScore = homeTeamScore,
    awayTeamScore = awayTeamScore,
)