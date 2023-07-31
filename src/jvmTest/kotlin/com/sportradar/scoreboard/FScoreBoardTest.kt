package com.sportradar.scoreboard

import com.sportradar.scoreboard.models.MatchInfo
import com.sportradar.scoreboard.models.MatchKey
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FScoreBoardTest {
    @Test
    internal fun startMatch() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        val matchInfo = scoreBoard.startMatch(matchKey)!!
        assertEquals(matchInfo.matchKey, matchInfo.matchKey)
        assertEquals(0, matchInfo.homeTeamScore)
        assertEquals(0, matchInfo.awayTeamScore)
    }

    @Test
    internal fun StartMatchTwice() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        scoreBoard.startMatch(matchKey)
        val matchInfo = scoreBoard.startMatch(matchKey)
        assertEquals(null, matchInfo)
    }

    @Test
    internal fun updateScoreNonExistentMatch() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        val matchInfo = scoreBoard.updateScore(matchKey, 1, 0)
        assertEquals(null, matchInfo)
    }

    @Test
    internal fun updateScoreStartedMatch() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        scoreBoard.startMatch(matchKey)
        val matchInfo = scoreBoard.updateScore(matchKey, 1, 0)!!
        assertEquals(matchInfo.matchKey, matchInfo.matchKey)
        assertEquals(1, matchInfo.homeTeamScore)
        assertEquals(0, matchInfo.awayTeamScore)
    }

    @Test
    internal fun finishMatchInexistentMatch() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        val matchInfo = scoreBoard.finishMatch(matchKey)
        assertEquals(null, matchInfo)
    }

    @Test
    internal fun finishMatchSuccesful() {
        val scoreBoard = FScoreBoard()
        val matchKey = MatchKey("Canada", "Mexico")
        scoreBoard.startMatch(matchKey)
        val matchInfo = scoreBoard.finishMatch(matchKey)!!
        assertEquals(matchKey, matchInfo.matchKey)
    }

    @Test
    internal fun getMatchesEmptyList() {
        val scoreBoard = FScoreBoard()
        val result = scoreBoard.getMatches()
        assertEquals(emptyList<MatchInfo>(), result)
    }

    @Test
    internal fun getMatchesUpdatedScoreforOneMatch() {
        val scoreBoard = FScoreBoard()
        val matchKey1 = MatchKey("Canada", "Mexico")
        val matchKey2 = MatchKey("Spain", "Brazil")
        scoreBoard.startMatch(matchKey1)
        scoreBoard.startMatch(matchKey2)
        scoreBoard.updateScore(matchKey1, 1, 0)!!
        val resultList = scoreBoard.getMatches()
        assertEquals(resultList.get(0).matchKey, matchKey1)
        assertEquals(resultList.get(1).matchKey, matchKey2)
    }

    @Test
    internal fun getMatchesUpdatedScoreforTwoMatchesWithTheSameScore() {
        val scoreBoard = FScoreBoard()
        val matchKey1 = MatchKey("Canada", "Mexico")
        val matchKey2 = MatchKey("Spain", "Brazil")
        scoreBoard.startMatch(matchKey1)
        scoreBoard.startMatch(matchKey2)
        scoreBoard.updateScore(matchKey1, 1, 0)!!
        scoreBoard.updateScore(matchKey2, 1, 0)!!
        val resultList = scoreBoard.getMatches()
        assertEquals(resultList.get(0).matchKey, matchKey2)
        assertEquals(resultList.get(1).matchKey, matchKey1)
    }
}