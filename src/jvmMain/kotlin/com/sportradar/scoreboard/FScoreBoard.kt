package com.sportradar.scoreboard

class FScoreBoard : IFScoreBoard {

    /**
     * Starts the match with the score 0 - 0
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    override fun startMatch(matchKey: MatchKey): MatchInfo? {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    /**
     * Ends the match and removes it from scoreBoard
     * Parameters:
     * matchKey - Pair of homeTeam and awayTeam
     * Returns:
     * matchinfo if the call is succesful or null otherwise
     */
    override fun finishMatch(matchKey: MatchKey): MatchInfo? {
        TODO("Not yet implemented")
    }

    /**
     * Get the list running matches info
     * Returns:
     * list of matchinfo for running matches or empty list otherwise.The matches
     * with the same total score will be returned ordered by the most recently
     * started match in the scoreboard.
     */
    override fun getMatches(): List<MatchInfo> {
        TODO("Not yet implemented")
    }

}