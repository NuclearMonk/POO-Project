package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.Brain;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class DeleteThis {
	@Test
	public void CrashTeste() {
		Brain brain = new Brain();
		/* 81 */Hand hand = new Hand("TC AC AH AS AD");
		PlayerAction A = brain.getAction(hand);
		Integer[] indexes = {1,2,3,4};
		assertEquals(new HoldCardsAction(Arrays.asList(indexes)), brain.getAction(hand));
	}
}
