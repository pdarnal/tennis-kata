package fr.rolandcarlos.tennis;

public class TennisGameSp1 implements TennisGame {

	protected int scorePlayer1 = 0;
	protected int scorePlayer2 = 0;
	
	protected String messageStatus = "";
	protected boolean finished = false;
	
	public void add1PointForPlayer1() {
		if (!finished) {
			scorePlayer1++;
			applyRules();
		}
	}
	
	public void add1PointForPlayer2() {
		if (!finished) {
			scorePlayer2++;
			applyRules();
		}
	}
	
	protected void applyRules() {
		messageStatus = "";
		
		if (haveWinner()) {
			messageStatus = "Player " + (scorePlayer1 > scorePlayer2 ? "1" : "2")  + " win the game";
			gameOver();
		}
	}
	
	protected boolean haveWinner() {
		return scorePlayer1 == 4 || scorePlayer2 == 4;
	}
	
	protected void gameOver() {
		gameReset();
		finished = true;
	}
	
	protected void gameReset() {
		scorePlayer1 = 0;
		scorePlayer2 = 0;
	}
	
	public String getGameStatus() {
		return "Player 1 : " + PrintScoreUtil.getScore(scorePlayer1) 
				+ ", Player 2 : " + PrintScoreUtil.getScore(scorePlayer2) 
				+ ", Game status : " + messageStatus;
	}

}
