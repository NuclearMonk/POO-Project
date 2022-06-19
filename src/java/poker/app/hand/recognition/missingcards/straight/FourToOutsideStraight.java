package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
/**
 * 
 * Four To Outside Straight recognizer
 *
 */
public class FourToOutsideStraight extends FourToStraight {
	/**
	 * Public Constructor
	 */
	public FourToOutsideStraight() {
	}
	/**
	 * Recognizing Where there is a straight in the hand that misses a card and can
	 * be completed with a card from either side 
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult superResult = super.recognizeHand(hand);
		if (superResult.isResult()) {
			List<Integer> straightMembers = getStraightMembers(hand);
			for (int i = 1; i < straightMembers.size(); i++) {
				if (straightMembers.get(i - 1) - straightMembers.get(i) != -1) {
					return new HandRecognitionResult(false, null);
				}
			}
			if (straightMembers.contains(Card.ACE)) {
				return new HandRecognitionResult(false, null);
			}
			return superResult;
		}
		return superResult;
	}

}
