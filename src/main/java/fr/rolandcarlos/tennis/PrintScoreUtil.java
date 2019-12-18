package fr.rolandcarlos.tennis;

public class PrintScoreUtil {
	private PrintScoreUtil () {}
	
	public static String getScore(int playerScore) {
		switch (playerScore) {
		case 0 :
			return "0";
		case 1 :
			return "15";
		case 2 :
			return "30";
		case 3 :
			return "40";
		}
		throw new IllegalArgumentException("Illegal score: " + playerScore);
	}
	
	public static String getAdvanceScore(int score1, int score2) {
		return score1 > score2 ? "ADV" : "40";
	}
}
