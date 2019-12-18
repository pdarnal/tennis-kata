package fr.rolandcarlos.tennis;

import org.junit.*;

public class TennisGameSp4Test {

	@Test
	public void testPlayer1AndPlayer2Equal6GamesTo6 () {
		TennisGame tg = new TennisGameSp4();
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
			player2WinSet(tg);
		}
		String status = tg.getGameStatus();
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 6, Player 1 Tie Break Score : 0, Player 2 Tie Break Score : 0, Game status : ", status);
	}
	
	@Test
	public void testPlayer1LeadBy1AfterTieBreak () {
		TennisGame tg = new TennisGameSp4();
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
			player2WinSet(tg);
		}
		tg.add1PointForPlayer1();
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 6, Player 1 Tie Break Score : 1, Player 2 Tie Break Score : 0, Game status : ", status);
	}
	
	@Test
	public void testPlayer1Lead4To2AfterTieBreak () {
		TennisGame tg = new TennisGameSp4();
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
			player2WinSet(tg);
		}
		
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer1();
		}
		for (int i = 0; i < 2; i++) {
			tg.add1PointForPlayer2();
		}
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 6, Player 1 Tie Break Score : 4, Player 2 Tie Break Score : 2, Game status : ", status);
	}
	
	@Test
	public void testPlayer2Win7to6AfterTieBreak () {
		TennisGame tg = new TennisGameSp4();
		for (int i = 0; i < 6; i++) {
			player1WinSet(tg);
			player2WinSet(tg);
		}
		
		for (int i = 0; i < 6; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		tg.add1PointForPlayer2();
		tg.add1PointForPlayer2();
		
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 Game Score : 0, Player 2 Game Score : 0, Player 1 Set Score : 6, Player 2 Set Score : 7, Player 1 Tie Break Score : 0, Player 2 Tie Break Score : 0, Game status : Player 2 wins the set and match", status);
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
