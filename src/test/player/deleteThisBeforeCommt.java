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
	public void T29() {
		Player player = new SimulationPlayer(0);
		App app = new App(player, null);
		/* 29 */app.setHand(new Hand("KC QH JS 9H 8H"));
		Integer[] indexes = { 0, 1, 2, 3 };
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
	}
}