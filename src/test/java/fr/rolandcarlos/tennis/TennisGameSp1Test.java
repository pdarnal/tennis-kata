package fr.rolandcarlos.tennis;

import org.junit.*;

public class TennisGameSp1Test {

	@Test
	public void testAdd1PointToPlayer1 () {
		TennisGame tg = new TennisGameSp1();
		tg.add1PointForPlayer1();
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 15, Player 2 : 0, Game status : ", status);
	}
	
	@Test
	public void testAdd1PointToPlayer1AndPlayer2 () {
		TennisGame tg = new TennisGameSp1();
		tg.add1PointForPlayer1();
		tg.add1PointForPlayer2();
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 15, Player 2 : 15, Game status : ", status);
	}
	
	@Test
	public void testPlayer1AndPlayer2Both40 () {
		TennisGame tg = new TennisGameSp1();
		for (int i = 0; i < 3; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 40, Player 2 : 40, Game status : ", status);
	}
	
	@Test
	public void testPlayer1WinGameAt40Both () {
		TennisGame tg = new TennisGameSp1();
		for (int i = 0; i < 3; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		tg.add1PointForPlayer1();
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 0, Player 2 : 0, Game status : Player 1 win the game", status);
	}
}
