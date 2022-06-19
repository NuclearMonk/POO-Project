package src.java.poker.app.hand.recognition.sequence;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
/**
 * 
 * Royal Flush Recognizer
 *
 */
public class RoyalFlushRecognizer extends StraightFlushRecognizer {
	/**
	 * public constructor that sets the handName to "ROYAL FLUSH" and
	 * rewardMultiplier to 250
	 */
	public RoyalFlushRecognizer() {
		super("ROYAL FLUSH", 250);
	}

	/**
	 * Recognize if the hand has a Royal flush
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (!result.isResult())
			return result;
		if (result.getDefiningCard().getValue() == Card.ACE) {
			return result;
		}
		return new HandRecognitionResult(false, null);
	}

}
