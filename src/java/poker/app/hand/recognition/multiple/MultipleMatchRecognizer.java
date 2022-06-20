package src.java.poker.app.hand.recognition.multiple;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

/**
 * 
 * Abstract class for Multiple Match Recognizer
 *
 */
public abstract class MultipleMatchRecognizer extends HandRecognizer {
	private final int lowCount;
	private final int highCount;

	/**
	 * protected Constructor
	 * 
	 * @param handName         to give for the
	 * @param rewardMultiplier which is equal to the amount the bet will be multiply
	 *                         by
	 * @param lowCount         the time of the first intended value to be repeated
	 * @param highCount        the time of the second intended value to be repeated
	 * 
	 */
	protected MultipleMatchRecognizer(String handName, int rewardMultiplier, int lowCount, int highCount) {
		super(handName, rewardMultiplier);
		this.lowCount = lowCount;
		this.highCount = highCount;
	}

	/**
	 * Recognize if the hand has Multiple Matches i.e. more than one card has one or
	 * more cards with the same value
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		Card lowCard = null;
		Card highCard = null;

		for (int i = Card.ACE; i <= Card.KING; i++) {
			List<Card> cards = hand.findCards(i);
			if (cards.size() == lowCount && cards.size() == highCount) {
				if (lowCard == null) {
					lowCard = cards.get(0);
				} else {
					highCard = cards.get(0);
				}
			} else if (cards.size() == lowCount) {
				lowCard = cards.get(0);
			} else if (cards.size() == highCount) {
				highCard = cards.get(0);
			}
		}

		if (lowCard != null && highCard != null && lowCard.getValue() != highCard.getValue()) {
			if (lowCard.getValue() == Card.ACE) {
				return new HandRecognitionResult(true, lowCard);
			}
			return new HandRecognitionResult(true, highCard);
		}
		return new HandRecognitionResult(false, null);
	}

}
