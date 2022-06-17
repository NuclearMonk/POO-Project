package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class ThreeToStraightFlushTwo extends ToStraightFlush {

	public ThreeToStraightFlushTwo() {
		super(3);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult superResult = super.recognizeHand(hand);
		boolean twoThreeFour  = true;
		if (!superResult.isResult())
			return new HandRecognitionResult(false, null);
		List<Integer> straightMembers = this.getStraightFlushMembers(hand);
		for (int i = 0; i < straightMembers.size(); i++)
		{
			if (straightMembers.get(i) != i+2)
				twoThreeFour = false;
			if (straightMembers.get(i) > Card.TEN || straightMembers.get(i) == Card.ACE)
				return superResult;
		}
		if (twoThreeFour)
			return superResult;
		return new HandRecognitionResult(false, null);	
	}

}
