package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithThreeHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithTwoHighCards;
import src.java.poker.app.hand.recognition.oneOrTwoCards.TwoSuitedHighCard;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class deleteThisBeforeCommt {
	@Test
	public void T24() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 37 */app.setHand(new Hand("AC JC 2S 3S 5S"));
		Integer[] indexes = { 0, 1 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
}
}