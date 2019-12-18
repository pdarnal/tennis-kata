package fr.rolandcarlos.tennis;

public class TennisGameSp3 extends TennisGameSp2 {
	protected int scoreSetPlayer1 = 0;
	protected int scoreSetPlayer2 = 0;
	
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
		
		if (haveWinSet()) {
			messageStatus = "Player " + (scoreSetPlayer1 > scoreSetPlayer2 ? "1" : "2")  + " wins the set and match";
			gameOver();
		}
	}
	
	protected boolean haveWinGame() {
		return (scorePlayer1 >= 4 && scorePlayer1 >= scorePlayer2 + 2)
				|| (scorePlayer2 >= 4 && scorePlayer2 >= scorePlayer1 + 2);
	}
	
	protected boolean haveWinSet() {
		return scoreSetPlayer1 == 7
				|| scoreSetPlayer2 == 7
				|| (scoreSetPlayer1 == 6 && scoreSetPlayer2 <= 4)
				|| (scoreSetPlayer2 == 6 && scoreSetPlayer1 <= 4);
	}
	
	public String getGameStatus() {
		if (!deuceMode()) {
			return "Player 1 Game Score : " + PrintScoreUtil.getScore(scorePlayer1) 
					+ ", Player 2 Game Score : " + PrintScoreUtil.getScore(scorePlayer2) 
					+ ", Player 1 Set Score : " + scoreSetPlayer1 
					+ ", Player 2 Set Score : " + scoreSetPlayer2
					+ ", Game status : " + messageStatus;
		}
		
		// deuce mode
		if (scorePlayer1 == scorePlayer2) {
			return "Player 1 Game Score : DEUCE, Player 2 Game Score : DEUCE"
			+ ", Player 1 Set Score : " + scoreSetPlayer1 
			+ ", Player 2 Set Score : " + scoreSetPlayer2
			+ ", Game status : " + messageStatus;
		} else {
			return "Player 1 Game Score : " + PrintScoreUtil.getAdvanceScore(scorePlayer1, scorePlayer2)
			+ ", Player 2 Game Score : " + PrintScoreUtil.getAdvanceScore(scorePlayer2, scorePlayer1)
			+ ", Player 1 Set Score : " + scoreSetPlayer1 
			+ ", Player 2 Set Score : " + scoreSetPlayer2
			+ ", Game status : " + messageStatus;
		}
	}
}
