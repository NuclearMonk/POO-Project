package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.count.OfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

/**
 * 
 * To recognize ThreeAces
 *
 */
public class ThreeAces extends OfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "Three Aces" and
	 * rewardsMultiplayer to 1
	 */

	public ThreeAces() {
		super("Three Aces", 3, 3);
	}

	/**
	 * 
	 * @param hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 * 
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(Card.ACE);
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where the hand has Three Ace
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {

		HandRecognitionResult result = super.recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() == Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
