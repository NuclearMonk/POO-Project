package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

/**
 * recognizer if the hand has King, Jack and Queen regardless of the suit
 * 
 *
 */
public class KQJUnsuited extends ThreeToStraight {
	/**
	 * recognize if the hand has King, Queen and Jack
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult superResult = super.recognizeHand(hand);
		if (superResult.isResult()) {
			List<Integer> values = getStraightMembers(hand);
			for (int i = 0; i < 3; i++) {
				if (values.get(i) < Card.JACK)
					return new HandRecognitionResult(false, null);
			}
			return superResult;
		}
		return new HandRecognitionResult(false, null);
	}

}
