package src.java.poker.app.hand.recognition.missingcards.flush;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
/**
 * 
 * Three To Flush with One High Card recognizer
 *
 */
public class ThreeToFlushOneHighCard extends ToFlush {
	/**
	 * Public Constructor of the class that set handName to "Three to flush with one
	 * High Card" and rewardsMultiplayer to 0 and count to 3
	 */
	public ThreeToFlushOneHighCard() {
		super("Three to flush with one High Card", 0, 3);
	}

	/**
	 * Recognizing Where there are 3 cards with the same suit and one of them is
	 * High card
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
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