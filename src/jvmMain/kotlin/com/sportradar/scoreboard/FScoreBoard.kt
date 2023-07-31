package com.sportradar.scoreboard

import com.sportradar.scoreboard.interfaces.IFScoreBoard
import com.sportradar.scoreboard.models.Match
import com.sportradar.scoreboard.models.MatchInfo
import com.sportradar.scoreboard.models.MatchKey
import com.sportradar.scoreboard.models.toMatchInfo
import java.time.Instant
import java.util.HashMap

class FScoreBoard : IFScoreBoard {

    private val boardMap: HashMap<MatchKey, Match> = HashMap<MatchKey, Match>()

    /**
     * Starts the match with the score 0 - 0
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    override fun startMatch(matchKey: MatchKey): MatchInfo? {
        val newMatch = Match(matchKey, Instant.now())
        val result = boardMap.putIfAbsent(matchKey, newMatch)
        if (result == null)
            return newMatch.toMatchInfo()
        else
            return null
    }

    /**
     * Update score of the match.
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * homeTeamScore and awayTeamScore as values to be updated
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    override fun updateScore(matchKey: MatchKey, homeTeamScore: Int, awayTeamScore: Int): MatchInfo? {
        val storedMatch = boardMap.get(matchKey)
        storedMatch?.updateScore(homeTeamScore, awayTeamScore)
        return storedMatch?.toMatchInfo()
    }

    /**
     * Ends the match and removes it from scoreBoard
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchInfo if the call is succesful or null otherwise
     */
    override fun finishMatch(matchKey: MatchKey): MatchInfo? {
        val previousMatch = boardMap.remove(matchKey)
        return previousMatch?.toMatchInfo()
    }

    /**
     * Get the list running matches info
     * Returns:
     * list of matchinfo for running matches or empty list otherwise.The matches
     * with the same total score will be returned ordered by the most recently
     * started match in the scoreboard.
     */
    override fun getMatches(): List<MatchInfo> {
        return boardMap.values.sortedWith(compareByDescending<Match> { it.homeTeamScore + it.awayTeamScore }
            .thenByDescending { it.creationTime })
            .map { it.toMatchInfo() }
    }

}