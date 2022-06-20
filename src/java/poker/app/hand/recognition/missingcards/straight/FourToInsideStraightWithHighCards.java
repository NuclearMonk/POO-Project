package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

/**
 * Abstract class to check if hand has four to inside straight with high cards
 *
 */
public abstract class FourToInsideStraightWithHighCards extends FourToStraight {
	protected final int numberOfHighCards;

	/**
	 * protected Constructor
	 * 
	 * @param numberOfHighCards that we would like to compare to
	 */
	protected FourToInsideStraightWithHighCards(int numberOfHighCards) {
		super();
		this.numberOfHighCards = numberOfHighCards;
	}

	/**
	 * Recognizing Where there is a straight in the hand that misses a card and can
	 * not be completed with any other card, and it has a number of high cards that
	 * matches numberOfHighCards
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {

		HandRecognitionResult fourToStraight = super.recognizeHand(hand);

		if (fourToStraight.isResult()) {
			List<Integer> straightMembers = getStraightMembers(hand);
			if (!straightMembers.contains(Card.ACE)) {
				for (int i = 1; i < straightMembers.size(); i++) {
					if (straightMembers.get(i - 1) - straightMembers.get(i) == -1) {
						break;
					} else if (i == straightMembers.size() - 1)
						return new HandRecognitionResult(false, null);
				}
			}
			if (this.numberOfHighCards == 0)
				return fourToStraight;
			else {
				int counter = 0;
				for (int i = 1; i < straightMembers.size(); i++) {
					if (straightMembers.get(i) > Card.TEN || straightMembers.get(i) == Card.ACE) {
						counter = counter + 1;
					}
				}
				if (counter == this.numberOfHighCards) {
					return fourToStraight;
				}
			}
		}
		return new HandRecognitionResult(false, null);

	}

}
