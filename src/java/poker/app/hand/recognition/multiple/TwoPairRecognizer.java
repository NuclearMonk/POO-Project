package src.java.poker.app.hand.recognition.multiple;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class TwoPairRecognizer extends MultipleMatchRecognizer {
	/**
	 * public constructor that sets handName to "TWO PAIR", multipleReward to 1 and
	 * lowCount and highCount to 2
	 */
	public TwoPairRecognizer() {
		super("TWO PAIR", 1, 2, 2);

	}

	/**
	 * 
	 * 
	 * @param Hand to give the action according to
	 * @return PlayerAction to hold cards that matches the class criterion
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		ArrayList<Integer> indexes = new ArrayList<>();
		Card definingCard = this.recognizeHand(hand).getDefiningCard();
		int highCardValue = definingCard.getValue();
		List<Card> handAsList = hand.cardsAsList();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (handAsList.get(i).getValue() != highCardValue) {
				int handCount = hand.findCards(hand.getCardByIndex(i).getValue()).size();
				if (handCount == 2) {
					indexes.add(i);
				}
			}
		}
		indexes.addAll(hand.getCardIndex(highCardValue));
		return new HoldCardsAction(indexes);
	}

}
