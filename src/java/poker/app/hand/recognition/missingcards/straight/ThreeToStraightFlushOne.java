package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
/**
 * 
 *three to straight flush recognizer type 1
 *
 */
public class ThreeToStraightFlushOne extends ToStraightFlush {
	/**
	 * public constructor that set countToStraightFlush to 3
	 */
	public ThreeToStraightFlushOne() {
		super(3);
	}

	/**
	 * recognize if the hand has straight flush that misses two cards and it is a
	 * Type 1
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult superResult = super.recognizeHand(hand);
		if (!superResult.isResult())
			return new HandRecognitionResult(false, null);
		List<Card> straightMembers = this.getStraightFlushMembers(hand);
		if (straightMembers.get(0).getValue() == Card.ACE) {
			return new HandRecognitionResult(false, null);
		}
		if (straightMembers.get(2).getValue() == Card.ACE) {
			if (straightMembers.get(0).getValue() >= Card.TEN && straightMembers.get(1).getValue() >= Card.TEN)
				return superResult;
			else
				return new HandRecognitionResult(false, null);
		}
		int gap = 0;
		int highCardConter = 0;
		boolean twoThreeFour = true;
		for (int i = 1; i < straightMembers.size(); i++) {

			if (straightMembers.get(i).getValue() - straightMembers.get(i - 1).getValue() != 1)
				gap = gap + (straightMembers.get(i).getValue() - straightMembers.get(i - 1).getValue() - 1);

		}
		for (int i = 0; i < straightMembers.size(); i++) {
			if (straightMembers.get(i).getValue() != i + 2)
				twoThreeFour = false;
			if (straightMembers.get(i).getValue() > Card.TEN)
				highCardConter = highCardConter + 1;
		}
		if ((highCardConter >= (gap)) && (!twoThreeFour)) {
			return superResult;
		} else {
			return new HandRecognitionResult(false, null);
		}

	}
}
