package fr.rolandcarlos.tennis;

public class TennisGameSp2 extends TennisGameSp1 {
	protected boolean haveWinner() {
		return (scorePlayer1 >= 4 && scorePlayer1 >= scorePlayer2 + 2)
				|| (scorePlayer2 >= 4 && scorePlayer2 >= scorePlayer1 + 2);
	}
	
	public String getGameStatus() {
		if (!deuceMode()) {
			return "Player 1 : " + PrintScoreUtil.getScore(scorePlayer1) 
					+ ", Player 2 : " + PrintScoreUtil.getScore(scorePlayer2) 
					+ ", Game status : " + messageStatus;
		}
		
		// deuce mode
		if (scorePlayer1 == scorePlayer2) {
			return "Player 1 : DEUCE, Player 2 : DEUCE"
			+ ", Game status : " + messageStatus;
		} else {
			return "Player 1 : " + PrintScoreUtil.getAdvanceScore(scorePlayer1, scorePlayer2)
			+ ", Player 2 : " + PrintScoreUtil.getAdvanceScore(scorePlayer2, scorePlayer1)
			+ ", Game status : " + messageStatus;
		}
	}
	
	protected boolean deuceMode() {
		return (scorePlayer1 > 3 && scorePlayer1 >= scorePlayer2)
				|| (scorePlayer2 > 3 && scorePlayer2 >= scorePlayer1);
	}
}
