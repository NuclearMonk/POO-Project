package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class KQJUnsuited extends ThreeToStraight {

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
