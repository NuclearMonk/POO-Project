package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.count.OfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class ThreeAces extends OfAKindRecognizer {

	public ThreeAces() {
		super("Three Aces", 3, 3);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(Card.ACE);
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {

		HandRecognitionResult result = super.recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() == Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
