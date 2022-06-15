package src.java.poker.app.hand.recognition.missingcards.flush;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class ThreeToFlushOneHighCard extends ToFlush {

	public ThreeToFlushOneHighCard() {
		super("Three to flush with one High Card", 0, 3);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		Card definingCard = result.getDefiningCard();
		Boolean finalResult = false;
		if (result.isResult() && (definingCard.getValue() >= Card.JACK || definingCard.getValue() == Card.ACE))
		// next card is at most Ten
		{
			finalResult = true;
		}

		return new HandRecognitionResult(finalResult, definingCard);
	}
}