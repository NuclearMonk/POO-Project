package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class SimPlayerFullPDFTest {
	@Test
	public void T1() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 1 */app.setHand(new Hand("KC QC JC TC 9C"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T2() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 2 */app.setHand(new Hand("AD KD QS JD TD"));
		Integer[] indexes = { 0, 1, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T3() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 3 */app.setHand(new Hand("AS KS JS TS 9S"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T4() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 4 */app.setHand(new Hand("AH AD AS 2C 2S"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T5() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 5 */app.setHand(new Hand("4C 4S 4H 5D 5C"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T6() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 6 */ app.setHand(new Hand("5S 6S 7S 8S JS"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T7() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 7 */ app.setHand(new Hand("3D 4H 5H 6H 7H"));
		Integer[] indexes = { 0, 1, 2, 3 , 4};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T8() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 8 */ app.setHand(new Hand("AC KD QD JD TS"));
		Integer[] indexes = { 0, 1, 2, 3, 4};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T9() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 9 */ app.setHand(new Hand("KC QC JC 9C 4D"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T10() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 10 */app.setHand(new Hand("AH AS KD KS QS"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T11() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 11 */app.setHand(new Hand("JC JD 4D 7D 9D"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T12() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 12 */app.setHand(new Hand("QS QH JH AH 2C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T13() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 13 */app.setHand(new Hand("8C JC QC KC 9H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T14() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 14 */app.setHand(new Hand("2S 5S 7S 9S 7H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T15() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 15 */app.setHand(new Hand("TD JD QC KD 5S"));
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T16() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 16 */app.setHand(new Hand("TH QH AH TD 8C"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T17() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 17 */app.setHand(new Hand("7C 7D 8H 9S TD"));
		Integer[] indexes = { 0, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T18() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 18 */app.setHand(new Hand("7D 8D 9D TS 4H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T19() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 19 */app.setHand(new Hand("7C 7D 8D 9D 3S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T20() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 20 */app.setHand(new Hand("KS QD JC 9H 9C"));
		Integer[] indexes = { 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T21() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 21 */app.setHand(new Hand("AC KD QH JH 8H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T22() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 22 */app.setHand(new Hand("AC KD QH JH 9S"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T23() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 23 */app.setHand(new Hand("AC KD QH JH 2C"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T24() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 24 */app.setHand(new Hand("2H QS JS 9D 8S"));
		PlayerAction A = app.getPlayer().getAction(app.getHand());
		//Recognize the class fail to return right indexes TODO
		Integer[] indexes = { 1, 2, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T25() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 25 */app.setHand(new Hand("8H TH JH 3S 5D"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T26() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 26 */app.setHand(new Hand("KS QD JD 9H 7C"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T27() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 27 */app.setHand(new Hand("AH KC QC TD 6C"));
		PlayerAction A = app.getPlayer().getAction(app.getHand());
		
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T28() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 28 */app.setHand(new Hand("KH QS JS 9D 3C"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T29() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 29 */app.setHand(new Hand("KC QH JS 9H 8H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T30() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 30 */app.setHand(new Hand("QD JD 7D 5H 4S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T31() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 31 */app.setHand(new Hand("8S 9H JD QD 2C"));
		Integer[] indexes = { 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T32() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 32 */app.setHand(new Hand("QS JS 2H 3H 4H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T33() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 33 */app.setHand(new Hand("KH JH 3H 5S 6C"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T34() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 34 */app.setHand(new Hand("8S 9C JD QD 4D"));
		Integer[] indexes = { 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T35() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 35 */app.setHand(new Hand("2C 3D 5H JC AC"));
		Integer[] indexes = { 0, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T36() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 36 */app.setHand(new Hand("KH JH TS 9D 6C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T37() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 37 */app.setHand(new Hand("AC JC 2S 3S 5S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T38() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 38 */app.setHand(new Hand("8D 9D JH QD 4C"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T39() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 39 */app.setHand(new Hand("8S 9D JD QH 3D"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T40() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 40 */app.setHand(new Hand("8C 9C TD QC 2H"));
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T41() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 41 */app.setHand(new Hand("7C 8H TD JD 4S"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T42() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 42 */app.setHand(new Hand("7D 8C 9S JD 2D"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T43() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 43 */app.setHand(new Hand("AD 2C 4C 5C 7S"));
		Integer[] indexes = { 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T44() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 44 */app.setHand(new Hand("QH JS TS 2D 4C"));
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T45() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 45 */app.setHand(new Hand("JH TH 6H 7S 2D"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T46() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 46 */app.setHand(new Hand("JD TD 2C 4C 6C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T47() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 47 */app.setHand(new Hand("JS TS KC 3D 7H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T48() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 48 */app.setHand(new Hand("JS TS AH 4D 6C"));
		Integer[] indexes = { 0, 1};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T49() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 49 */app.setHand(new Hand("6S 7C 8D TH JH"));
		Integer[] indexes = { 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T50() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 50 */app.setHand(new Hand("JD TD 2C 5C 7C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T51() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 51 */app.setHand(new Hand("QC JH 9H 4H 2S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T52() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 52 */app.setHand(new Hand("QC JD TC 3S 5H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T53() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 53 */app.setHand(new Hand("QS JD 5H 6H 9H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T54() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 54 */app.setHand(new Hand("AD QC JS 4H 7S"));
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T55() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 55 */app.setHand(new Hand("QC JH 2D 5D 7D"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T56() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 56 */app.setHand(new Hand("7C TC QC 3H 2D"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T57() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 57 */app.setHand(new Hand("KS QH 8H 5H 2C"));
		Integer[] indexes = { 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T58() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 58 */app.setHand(new Hand("AD 5D 9D 8S 6H"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T59() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 59 */app.setHand(new Hand("7C TC KC 3H 2D"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T60() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 60 */app.setHand(new Hand("6C 7S 9C TH KC"));
		Integer[] indexes = { 0, 2, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T61() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 61 */app.setHand(new Hand("QH TH 2C 4C 6C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T62() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 62 */app.setHand(new Hand("KH QS TS 4C 5D"));
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T63() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 63 */app.setHand(new Hand("AC QD TD 6S 9H"));
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T64() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 64 */app.setHand(new Hand("QD TD 8H 7C 6S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T65() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 65 */app.setHand(new Hand("QS TS 3H 7H 8H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T66() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 66 */app.setHand(new Hand("5C 6C 9C KD QH"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T67() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 67 */app.setHand(new Hand("3H 5H 7H JS 8D"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T68() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 68 */app.setHand(new Hand("2C 3C 6C TD KD"));
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T69() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 69 */app.setHand(new Hand("2D 3D 5H 6D 9S"));
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T70() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 70 */app.setHand(new Hand("AD KC JS 7H 4C"));
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T71() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 71 */app.setHand(new Hand("KC QH TC 4D 6S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T72() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 72 */app.setHand(new Hand("KH JS 3D 8D 9D"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T73() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 73 */app.setHand(new Hand("AC KH TH 4S 5D"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T74() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 74 */app.setHand(new Hand("AC JH 5S 8D 9C"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T75() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 75 */app.setHand(new Hand("AD 5H 6S 7H 9D"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T76() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 76 */app.setHand(new Hand("AS 2C 5C 9C 6H"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T77() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 77 */app.setHand(new Hand("KD 6C 7S 9H TD"));
		Integer[] indexes = { 0, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T78() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 78 */app.setHand(new Hand("KC TC 3H 5H 8H"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T79() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 79 */app.setHand(new Hand("JH 2S 3C 4D 6H"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T80() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 80 */app.setHand(new Hand("QC 2H 5H 7H 9S"));
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T81() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 81 */app.setHand(new Hand("2D 3S 5C 6C TC"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}
}
