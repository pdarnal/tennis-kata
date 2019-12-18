package fr.rolandcarlos.tennis;

import org.junit.*;

public class TennisGameSp2Test {

	@Test
	public void testPlayer1AndPlayer2Both40 () {
		TennisGame tg = new TennisGameSp2();
		for (int i = 0; i < 3; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 40, Player 2 : 40, Game status : ", status);
	}
	
	@Test
	public void testAdvantagePlayer1AfterBoth40 () {
		TennisGame tg = new TennisGameSp2();
		for (int i = 0; i < 3; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		tg.add1PointForPlayer1();
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : ADV, Player 2 : 40, Game status : ", status);
	}
	
	@Test
	public void testDeuceAfterAdvantagePlayer1 () {
		TennisGame tg = new TennisGameSp2();
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : DEUCE, Player 2 : DEUCE, Game status : ", status);
	}
	
	@Test
	public void testAvantagePlayer2AfterDeuce () {
		TennisGame tg = new TennisGameSp2();
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		
		String status = tg.getGameStatus();
		Assert.assertEquals("Player 1 : DEUCE, Player 2 : DEUCE, Game status : ", status);
		
		tg.add1PointForPlayer2();
		status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 40, Player 2 : ADV, Game status : ", status);
	}
	
	@Test
	public void testPlayer1WinAfterAdvantagePlayer1 () {
		TennisGame tg = new TennisGameSp2();
		for (int i = 0; i < 4; i++) {
			tg.add1PointForPlayer1();
			tg.add1PointForPlayer2();
		}
		tg.add1PointForPlayer1();
		tg.add1PointForPlayer1();
		
		String status = tg.getGameStatus();
		
		Assert.assertEquals("Player 1 : 0, Player 2 : 0, Game status : Player 1 win the game", status);
	}
}
