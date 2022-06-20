package src.java.poker.app.hand.recognition.missingcards.straight;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

/**
 * To check if the hand has Ace, King, Queen and Jack regardless of the suite
 *
 */
public class AKQJUnsuited extends FourToStraight {
	/**
	 * Recognizing Where there is Ace,King, Queen and Jack in the hand
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult straightResult = super.recognizeHand(hand);
		if (straightResult.isResult())
			if (straightResult.getDefiningCard().getValue() == Card.JACK)
				return straightResult;
		return new HandRecognitionResult(false, null);
	}

}
