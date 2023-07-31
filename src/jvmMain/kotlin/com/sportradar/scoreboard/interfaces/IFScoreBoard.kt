package com.sportradar.scoreboard.interfaces

import com.sportradar.scoreboard.models.MatchInfo
import com.sportradar.scoreboard.models.MatchKey

interface IFScoreBoard {

    /**
     * Starts the match with the score 0 - 0
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    fun startMatch(matchKey: MatchKey): MatchInfo?

    /**
     * Update score of the match.
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * homeTeamScore and awayTeamScore as values to be updated
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    fun updateScore(matchKey: MatchKey, homeTeamScore:Int, awayTeamScore: Int): MatchInfo?

    /**
     * Ends the match and removes it from scoreBoard
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    fun finishMatch(matchKey: MatchKey): MatchInfo?

    /**
     * Get the list of running matches as MatchInfo
     * Returns:
     * list of MatchInfo for running matches ordered by their total score or
     * empty list otherwise.The matches with the same total score will be
     * returned ordered by the most recently started match in the scoreboard.
     */
    fun getMatches(): List<MatchInfo>
}