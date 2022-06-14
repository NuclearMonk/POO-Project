package src.java.poker.app.hand.analyzer.oneOrTwoCards;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.analyzer.HandAction;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class Ace extends HandRecognizer implements HandAction {

	protected Ace() {
		super("ACE", 0);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue(),
				this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == Card.ACE)
				return new HandRecognitionResult(true, C);
		}
		return new HandRecognitionResult(false, null);
	}
}
