package fr.rolandcarlos.tennis;

import org.junit.*;

public class TennisGameSp3Test {

	@Test
	public void testPlayer1Wins1stGame () {
		TennisGame tg = new TennisGameSp3();
		player1WinSet(tg);
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 1, Player 2 Set Score : 0, Game status : Player 1 wins the 1st game of the set", status);
	}
	
	@Test
	public void testPlayer1AndPlayer2Wins1Game () {
		TennisGame tg = new TennisGameSp3();
		player1WinSet(tg);
		player2WinSet(tg);
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 1, Player 2 Set Score : 1, Game status : ", status);
	}
	
	@Test
	public void testPlayer1WinsSet6GamesTo1 () {
		TennisGame tg = new TennisGameSp3();
		player2WinSet(tg);
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
		}
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 1, Game status : Player 1 wins the set and match", status);
	}
	
	@Test
	public void testPlayer2WinsSet7GamesTo6 () {
		TennisGame tg = new TennisGameSp3();
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
			player2WinSet(tg);
		}
		player2WinSet(tg);
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 7, Game status : Player 2 wins the set and match", status);
	}
	
	private void player1WinSet (TennisGame tg) {
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer1();
		}
	}
	
	private void player2WinSet (TennisGame tg) {
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer2();
		}
	}
}
