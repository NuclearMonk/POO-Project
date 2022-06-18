package src.java.poker.app.hand.recognition.count;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class JacksOrBetterRecognizer extends TwoOfAKindRecognizer {
	/*
	 * public Constructor of the class that set the handName to "JACKS OR BETTER"
	 * and rewardMultiplayer to 1
	 */
	public JacksOrBetterRecognizer() {
		super("JACKS OR BETTER", 1);
	}

	/**
	 * Recognizing Where there are Jack or better pair in the hand
	 * 
	 * @return HandRecognitionResult
	 * @param hand to check
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (!result.isResult())
			return result;
		if (result.getDefiningCard().getValue() < Card.JACK && result.getDefiningCard().getValue() != Card.ACE)
			return new HandRecognitionResult(false, null);
		return result;
	}
}
