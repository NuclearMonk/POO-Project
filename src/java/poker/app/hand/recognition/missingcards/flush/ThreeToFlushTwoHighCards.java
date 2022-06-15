package src.java.poker.app.hand.recognition.missingcards.flush;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class ThreeToFlushTwoHighCards extends ToFlush {

	public ThreeToFlushTwoHighCards() {
		super("Three To Flush with Two High Cards", 0, 3);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		Card definingCard = result.getDefiningCard();
		Boolean finalResult = false;
		if (result.isResult() && (definingCard.getValue() >= Card.QUEEN || definingCard.getValue() == Card.ACE)) // because
																													// if
																													// it
																													// is
																													// Jack
																													// then
																													// the
		// next card is at most Ten
		{
			// Now we check the other card
			for (Card C : hand.cardsAsList()) {
				if (!C.equals(definingCard)
						&& C.getSuit() == definingCard.getSuit()
						&& (C.getValue() >= Card.JACK
								|| C.getValue() == Card.ACE)) {
					finalResult = true;
					break;
				}
			}
		}

		return new HandRecognitionResult(finalResult, definingCard);
	}

}