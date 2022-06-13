package src.java.poker.app.hand.analyzer;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class TwoPairs extends HandAnalyzer implements HandAction {

	protected TwoPairs() {
		super("Two Pair");
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		Card DefiningCard = this.recognizeHand(hand).getDefiningCard();
		int highCardValue = DefiningCard.getValue();
		List<Card> handAsList = hand.cardsAsList();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (handAsList.get(i).getValue() == highCardValue)
				continue;
			else {
				int handCount = hand.findCards(hand.getCardByIndex(i).getValue()).size();
				if (handCount == 2) {
					indexes.add(i);
				}
			}
		}
		indexes.addAll(hand.getCardIndex(highCardValue));
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = new TwoPairRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		return new HandRecognitionResult(false, null);
	}

}
