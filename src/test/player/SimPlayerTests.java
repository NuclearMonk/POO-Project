package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.ThreeAces;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;

public class SimPlayerTests {
	@Test
	public void T1() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("KC QC JC TC 9C"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T2() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("AD KD QS JD TD"));
		Integer[] indexes = { 0, 1, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T3() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("AS KS JS TS 9S"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T4() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("AH AD AS 2C 2S"));
		assertEquals(true, new ThreeAces().recognizeHand(app.getHand()).isResult());
		Integer[] indexes = { 0, 1, 2 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T5() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("4C 4S 4H 5D 5C"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T6() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("5S 6S 7S 8S JS"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T7() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("3D 4H 5H 6H 7H"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T8() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("AC KD QD JD TS"));
		Integer[] indexes = { 0, 1, 2, 3, 4 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T9() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("KC QC JC 9C 4D"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T10() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("AH AS KD KS QS"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T11() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("JC JD 4D 7D 9D"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T12() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("QS QH JH AH 2C"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T13() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("8C JC QC KC 9H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T14() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("2S 5S 7S 9S 7H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}

	@Test
	public void T15() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		app.setHand(new Hand("KS AS QS JS 7H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}
}
