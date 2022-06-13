package src.java.poker.app.hand.analyzer;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.count.ThreeOfARecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class ThreeOfAKindNotAce extends HandAnalyzer implements HandAction {

	public ThreeOfAKindNotAce() {
		super("ThreeOfAKindNotAce");
		}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		Card DefiningCard = this.recognizeHand(hand).getDefiningCard();
		List<Integer> indexes = hand.getCardIndex(DefiningCard.getValue());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = new ThreeOfARecognizer().recognizeHand(hand);
		if (result.isResult() && result.getDefiningCard().getValue() != Card.ACE)
			return result;
		else
			return new HandRecognitionResult(false, null);
	}

}
