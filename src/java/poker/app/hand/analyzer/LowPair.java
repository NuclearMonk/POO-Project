package src.java.poker.app.hand.analyzer;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.count.TwoOfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class LowPair extends TwoOfAKindRecognizer implements HandAction {

	public LowPair() {
		super("Low Pair", 1);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() < Card.JACK
				&& result.getDefiningCard().getValue() != Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
