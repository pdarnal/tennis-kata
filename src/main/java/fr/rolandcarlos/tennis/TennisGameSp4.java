package fr.rolandcarlos.tennis;

public class TennisGameSp4 extends TennisGameSp3 {
	protected int scoreTieBreakPlayer1 = 0;
	protected int scoreTieBreakPlayer2 = 0;
	
	public void add1PointForPlayer1() {
		if (!finished) {
			if (tieBreakMode()) {
				scoreTieBreakPlayer1++;
			} else {
				scorePlayer1++;
			}
			applyRules();
		}
	}
	
	public void add1PointForPlayer2() {
		if (!finished) {
			if (tieBreakMode()) {
				scoreTieBreakPlayer2++;
			} else {
				scorePlayer2++;
			}
			applyRules();
		}
	}
	
	protected void applyRules() {
		messageStatus = "";
		
		if (haveWinGame()) {
			if (scorePlayer1 > scorePlayer2) {
				++scoreSetPlayer1;
			} else {
				++scoreSetPlayer2;
			}
			
			if ((scoreSetPlayer1 + scoreSetPlayer2) == 1) {
				messageStatus = "Player " + (scorePlayer1 > scorePlayer2 ? "1" : "2")  + " wins the 1st game of the set";
			}
			gameReset();
		}
		
		if (tieBreakMode() 
				&& ((scoreTieBreakPlayer1 >= 7 && scoreTieBreakPlayer1 >= scoreTieBreakPlayer2 + 2)
				||	(scoreTieBreakPlayer2 >= 7 && scoreTieBreakPlayer2 >= scoreTieBreakPlayer1 + 2))) {
			if (scoreTieBreakPlayer1 > scoreTieBreakPlayer2) {
				++scoreSetPlayer1;
			} else {
				++scoreSetPlayer2;
			}
		}
		
		if (haveWinSet()) {
			messageStatus = "Player " + (scoreSetPlayer1 > scoreSetPlayer2 ? "1" : "2")  + " wins the set and match";
			gameOver();
		}
	}
	
	private boolean tieBreakMode() {
		return scoreSetPlayer1 == 6 && scoreSetPlayer2 == 6;
	}
	
	protected void gameReset() {
		scorePlayer1 = 0;
		scorePlayer2 = 0;
		
		scoreTieBreakPlayer1 = 0;
		scoreTieBreakPlayer2 = 0;
	}
	
	public String getGameStatus() {
		if (!deuceMode()) {
			return "Player 1 Game Score : " + PrintScoreUtil.getScore(scorePlayer1) 
					+ ", Player 2 Game Score : " + PrintScoreUtil.getScore(scorePlayer2) 
					+ ", Player 1 Set Score : " + scoreSetPlayer1 
					+ ", Player 2 Set Score : " + scoreSetPlayer2
					+ ", Player 1 Tie Break Score : " + scoreTieBreakPlayer1 
					+ ", Player 2 Tie Break Score : " + scoreTieBreakPlayer2
					+ ", Game status : " + messageStatus;
		}
		
		// deuce mode
		if (scorePlayer1 == scorePlayer2) {
			return "Player 1 Game Score : DEUCE, Player 2 Game Score : DEUCE"
			+ ", Player 1 Set Score : " + scoreSetPlayer1 
			+ ", Player 2 Set Score : " + scoreSetPlayer2
			+ ", Player 1 Tie Break Score : " + scoreTieBreakPlayer1 
			+ ", Player 2 Tie Break Score : " + scoreTieBreakPlayer2
			+ ", Game status : " + messageStatus;
		} else {
			return "Player 1 Game Score : " + PrintScoreUtil.getAdvanceScore(scorePlayer1, scorePlayer2)
			+ ", Player 2 Game Score : " + PrintScoreUtil.getAdvanceScore(scorePlayer2, scorePlayer1)
			+ ", Player 1 Set Score : " + scoreSetPlayer1 
			+ ", Player 2 Set Score : " + scoreSetPlayer2
			+ ", Player 1 Tie Break Score : " + scoreTieBreakPlayer1 
			+ ", Player 2 Tie Break Score : " + scoreTieBreakPlayer2
			+ ", Game status : " + messageStatus;
		}
	}
}
