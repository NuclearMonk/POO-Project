package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class ThreeToStraightFlushTwo extends ToStraightFlush {
	/**
	 * public constructor that set countToStraightFlush to 3
	 */
	public ThreeToStraightFlushTwo() {
		super(3);
	}

	/**
	 * recognize if the hand has straight flush that misses two cards and it is a
	 * Type 2
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult superResult = super.recognizeHand(hand);
		boolean twoThreeFour = true;
		if (!superResult.isResult())
			return new HandRecognitionResult(false, null);
		List<Card> straightMembers = this.getStraightFlushMembers(hand);
		for (int i = 0; i < straightMembers.size(); i++) {
			if (straightMembers.get(i).getValue() != i + 2)
				twoThreeFour = false;
			if (straightMembers.get(i).getValue() > Card.TEN || straightMembers.get(i).getValue() == Card.ACE)
				return superResult;
		}
		if (twoThreeFour)
			return superResult;
		return new HandRecognitionResult(false, null);
	}

}
