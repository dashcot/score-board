package com.sportradar.scoreboard.models

import com.sportradar.scoreboard.models.MatchKey

data class MatchInfo(val matchKey: MatchKey, val homeTeamScore: Int, val awayTeamScore: Int)