package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.count.JacksOrBetterRecognizer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class HighPair extends JacksOrBetterRecognizer {
	/**
	 * @param Hand to give the action according to 
	 * @return PlayerAction to hold cards that matches the class criterion
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue());
		return new HoldCardsAction(indexes);
	}
}
