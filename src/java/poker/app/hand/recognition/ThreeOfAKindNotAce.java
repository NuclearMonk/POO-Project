package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.count.OfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class ThreeOfAKindNotAce extends OfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "Three Aces" and
	 * rewardsMultiplayer to 3
	 */
	public ThreeOfAKindNotAce() {
		super("Three Of A Kind But Not Ace", 3, 3);
	}

	/**
	 * 
	 * @param Hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 * 
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		Card definingCard = this.recognizeHand(hand).getDefiningCard();
		List<Integer> indexes = hand.getCardIndex(definingCard.getValue());
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where the hand has Three matching cards but not Aces
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() != Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
