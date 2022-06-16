package src.java.poker.app.hand.recognition.missingcards.straight;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class AKQJUnsuited extends FourToStraight {

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult straightResult = super.recognizeHand(hand);
		if (straightResult.isResult())
			if(straightResult.getDefiningCard().getValue() == Card.JACK)
				return straightResult;
		return new HandRecognitionResult(false,null);
	}
	

}
