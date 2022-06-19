package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
/**
 * 
 * Ace recognizer regardless of the suit
 *
 */
public class Ace extends HandRecognizer {
	/**
	 * public constructor set handName to "ACE" and rewardsMultiplayer to 0
	 */
	public Ace() {
		super("ACE", 0);
	}

	/**
	 * @return PlayerAction to hold the ace
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue(),
				this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognize if the hand has an Ace
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == Card.ACE)
				return new HandRecognitionResult(true, C);
		}
		return new HandRecognitionResult(false, null);
	}
}
