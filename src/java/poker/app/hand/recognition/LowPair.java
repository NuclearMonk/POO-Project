package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.count.TwoOfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class LowPair extends TwoOfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "Low Pair" and
	 * rewardsMultiplayer to 0
	 */

	public LowPair() {
		super("Low Pair", 0);
	}

	/**
	 * @param hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 */

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue());
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where all the hand has low Pair
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() < Card.JACK
				&& result.getDefiningCard().getValue() != Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
