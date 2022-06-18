package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.player.Brain;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class BrainFullPDFTest {
	@Test
	public void T1() {
		Brain brain = new Brain();
		/* 1 */Hand hand =new Hand("KC QC JC TC 9C");
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T2() {
		Brain brain = new Brain();
		/* 2 */Hand hand =new Hand("AD KD QS JD TD");
		Integer[] indexes = { 0, 1, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T3() {
		Brain brain = new Brain();
		/* 3 */Hand hand =new Hand("AS KS JS TS 9S");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T4() {
		Brain brain = new Brain();
		/* 4 */Hand hand =new Hand("AH AD AS 2C 2S");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T5() {
		Brain brain = new Brain();
		/* 5 */Hand hand =new Hand("4C 4S 4H 5D 5C");
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T6() {
		Brain brain = new Brain();
		/* 6 */ Hand hand =new Hand("5S 6S 7S 8S JS");
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T7() {
		Brain brain = new Brain();
		/* 7 */ Hand hand =new Hand("3D 4H 5H 6H 7H");
		Integer[] indexes = { 0, 1, 2, 3 , 4};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T8() {
		Brain brain = new Brain();
		/* 8 */ Hand hand =new Hand("AC KD QD JD TS");
		Integer[] indexes = { 0, 1, 2, 3, 4};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T9() {
		Brain brain = new Brain();
		/* 9 */ Hand hand =new Hand("KC QC JC 9C 4D");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T10() {
		Brain brain = new Brain();
		/* 10 */Hand hand =new Hand("AH AS KD KS QS");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T11() {
		Brain brain = new Brain();
		/* 11 */Hand hand =new Hand("JC JD 4D 7D 9D");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T12() {
		Brain brain = new Brain();
		/* 12 */Hand hand =new Hand("QS QH JH AH 2C");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T13() {
		Brain brain = new Brain();
		/* 13 */Hand hand =new Hand("8C JC QC KC 9H");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T14() {
		Brain brain = new Brain();
		/* 14 */Hand hand =new Hand("2S 5S 7S 9S 7H");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T15() {
		Brain brain = new Brain();
		/* 15 */Hand hand =new Hand("TD JD QC KD 5S");
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T16() {
		Brain brain = new Brain();
		/* 16 */Hand hand =new Hand("TH QH AH TD 8C");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T17() {
		Brain brain = new Brain();
		/* 17 */Hand hand =new Hand("7C 7D 8H 9S TD");
		Integer[] indexes = { 0, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T18() {
		Brain brain = new Brain();
		/* 18 */Hand hand =new Hand("7D 8D 9D TS 4H");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T19() {
		Brain brain = new Brain();
		/* 19 */Hand hand =new Hand("7C 7D 8D 9D 3S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T20() {
		Brain brain = new Brain();
		/* 20 */Hand hand =new Hand("KS QD JC 9H 9C");
		Integer[] indexes = { 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T21() {
		Brain brain = new Brain();
		/* 21 */Hand hand =new Hand("AC KD QH JH 8H");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T22() {
		Brain brain = new Brain();
		/* 22 */Hand hand =new Hand("AC KD QH JH 9S");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T23() {
		Brain brain = new Brain();
		/* 23 */Hand hand =new Hand("AC KD QH JH 2C");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T24() {
		Brain brain = new Brain();
		/* 24 */Hand hand =new Hand("2H QS JS 9D 8S");
		Integer[] indexes = { 1, 2, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T25() {
		Brain brain = new Brain();
		/* 25 */Hand hand =new Hand("8H TH JH 3S 5D");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T26() {
		Brain brain = new Brain();
		/* 26 */Hand hand =new Hand("KS QD JD 9H 7C");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T27() {
		Brain brain = new Brain();
		/* 27 */Hand hand =new Hand("AH KC QC TD 6C");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T28() {
		Brain brain = new Brain();
		/* 28 */Hand hand =new Hand("KH QS JS 9D 3C");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T29() {
		Brain brain = new Brain();
		/* 29 */Hand hand =new Hand("KC QH JS 9H 8H");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T30() {
		Brain brain = new Brain();
		/* 30 */Hand hand =new Hand("QD JD 7D 5H 4S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T31() {
		Brain brain = new Brain();
		/* 31 */Hand hand =new Hand("8S 9H JD QD 2C");
		Integer[] indexes = { 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T32() {
		Brain brain = new Brain();
		/* 32 */Hand hand =new Hand("QS JS 2H 3H 4H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T33() {
		Brain brain = new Brain();
		/* 33 */Hand hand =new Hand("KH JH 3H 5S 6C");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T34() {
		Brain brain = new Brain();
		/* 34 */Hand hand =new Hand("8S 9C JD QD 4D");
		Integer[] indexes = { 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T35() {
		Brain brain = new Brain();
		/* 35 */Hand hand =new Hand("2C 3D 5H JC AC");
		Integer[] indexes = { 0, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T36() {
		Brain brain = new Brain();
		/* 36 */Hand hand =new Hand("KH JH TS 9D 6C");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T37() {
		Brain brain = new Brain();
		/* 37 */Hand hand =new Hand("AC JC 2S 3S 5S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T38() {
		Brain brain = new Brain();
		/* 38 */Hand hand =new Hand("8D 9D JH QD 4C");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T39() {
		Brain brain = new Brain();
		/* 39 */Hand hand =new Hand("8S 9D JD QH 3D");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T40() {
		Brain brain = new Brain();
		/* 40 */Hand hand =new Hand("8C 9C TD QC 2H");
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T41() {
		Brain brain = new Brain();
		/* 41 */Hand hand =new Hand("7C 8H TD JD 4S");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T42() {
		Brain brain = new Brain();
		/* 42 */Hand hand =new Hand("7D 8C 9S JD 2D");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T43() {
		Brain brain = new Brain();
		/* 43 */Hand hand =new Hand("AD 2C 4C 5C 7S");
		Integer[] indexes = { 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T44() {
		Brain brain = new Brain();
		/* 44 */Hand hand =new Hand("QH JS TS 2D 4C");
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T45() {
		Brain brain = new Brain();
		/* 45 */Hand hand =new Hand("JH TH 6H 7S 2D");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T46() {
		Brain brain = new Brain();
		/* 46 */Hand hand =new Hand("JD TD 2C 4C 6C");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T47() {
		Brain brain = new Brain();
		/* 47 */Hand hand =new Hand("JS TS KC 3D 7H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T48() {
		Brain brain = new Brain();
		/* 48 */Hand hand =new Hand("JS TS AH 4D 6C");
		Integer[] indexes = { 0, 1};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T49() {
		Brain brain = new Brain();
		/* 49 */Hand hand =new Hand("6S 7C 8D TH JH");
		Integer[] indexes = { 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T50() {
		Brain brain = new Brain();
		/* 50 */Hand hand =new Hand("JD TD 2C 5C 7C");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T51() {
		Brain brain = new Brain();
		/* 51 */Hand hand =new Hand("QC JH 9H 4H 2S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T52() {
		Brain brain = new Brain();
		/* 52 */Hand hand =new Hand("QC JD TC 3S 5H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T53() {
		Brain brain = new Brain();
		/* 53 */Hand hand =new Hand("QS JD 5H 6H 9H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T54() {
		Brain brain = new Brain();
		/* 54 */Hand hand =new Hand("AD QC JS 4H 7S");
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T55() {
		Brain brain = new Brain();
		/* 55 */Hand hand =new Hand("QC JH 2D 5D 7D");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T56() {
		Brain brain = new Brain();
		/* 56 */Hand hand =new Hand("7C TC QC 3H 2D");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T57() {
		Brain brain = new Brain();
		/* 57 */Hand hand =new Hand("KS QH 8H 5H 2C");
		Integer[] indexes = { 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T58() {
		Brain brain = new Brain();
		/* 58 */Hand hand =new Hand("AD 5D 9D 8S 6H");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T59() {
		Brain brain = new Brain();
		/* 59 */Hand hand =new Hand("7C TC KC 3H 2D");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T60() {
		Brain brain = new Brain();
		/* 60 */Hand hand =new Hand("6C 7S 9C TH KC");
		Integer[] indexes = { 0, 2, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T61() {
		Brain brain = new Brain();
		/* 61 */Hand hand =new Hand("QH TH 2C 4C 6C");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T62() {
		Brain brain = new Brain();
		/* 62 */Hand hand =new Hand("KH QS TS 4C 5D");
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T63() {
		Brain brain = new Brain();
		/* 63 */Hand hand =new Hand("AC QD TD 6S 9H");
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T64() {
		Brain brain = new Brain();
		/* 64 */Hand hand =new Hand("QD TD 8H 7C 6S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T65() {
		Brain brain = new Brain();
		/* 65 */Hand hand =new Hand("QS TS 3H 7H 8H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T66() {
		Brain brain = new Brain();
		/* 66 */Hand hand =new Hand("5C 6C 9C KD QH");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T67() {
		Brain brain = new Brain();
		/* 67 */Hand hand =new Hand("3H 5H 7H JS 8D");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T68() {
		Brain brain = new Brain();
		/* 68 */Hand hand =new Hand("2C 3C 6C TD KD");
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T69() {
		Brain brain = new Brain();
		/* 69 */Hand hand =new Hand("2D 3D 5H 6D 9S");
		Integer[] indexes = { 0, 1, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T70() {
		Brain brain = new Brain();
		/* 70 */Hand hand =new Hand("AD KC JS 7H 4C");
		Integer[] indexes = { 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T71() {
		Brain brain = new Brain();
		/* 71 */Hand hand =new Hand("KC QH TC 4D 6S");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T72() {
		Brain brain = new Brain();
		/* 72 */Hand hand =new Hand("KH JS 3D 8D 9D");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T73() {
		Brain brain = new Brain();
		/* 73 */Hand hand =new Hand("AC KH TH 4S 5D");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T74() {
		Brain brain = new Brain();
		/* 74 */Hand hand =new Hand("AC JH 5S 8D 9C");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T75() {
		Brain brain = new Brain();
		/* 75 */Hand hand =new Hand("AD 5H 6S 7H 9D");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T76() {
		Brain brain = new Brain();
		/* 76 */Hand hand =new Hand("AS 2C 5C 9C 6H");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T77() {
		Brain brain = new Brain();
		/* 77 */Hand hand =new Hand("KD 6C 7S 9H TD");
		Integer[] indexes = { 0, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T78() {
		Brain brain = new Brain();
		/* 78 */Hand hand =new Hand("KC TC 3H 5H 8H");
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T79() {
		Brain brain = new Brain();
		/* 79 */Hand hand =new Hand("JH 2S 3C 4D 6H");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T80() {
		Brain brain = new Brain();
		/* 80 */Hand hand =new Hand("QC 2H 5H 7H 9S");
		Integer[] indexes = { 0 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}

	@Test
	public void T81() {
		Brain brain = new Brain();
		/* 81 */Hand hand =new Hand("2D 3S 5C 6C TC");
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}
}
