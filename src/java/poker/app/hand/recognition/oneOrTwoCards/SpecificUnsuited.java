package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class SpecificUnsuited extends HandRecognizer {
	final int highCard;
	final int lowCard;

	protected SpecificUnsuited(String handName, int lowCard, int highCard) {
		super(handName, 0);
		this.lowCard = lowCard;
		this.highCard = highCard;
	}

	public int getHighCard() {
		return highCard;
	}

	public int getLowCard() {
		return lowCard;
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		boolean lowCardFound = false;
		boolean highCardFound = false;
		Card definingCard = null;
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == this.highCard) {
				highCardFound = true;
			}
			else if (C.getValue() >= this.lowCard) {
				lowCardFound = true;
				definingCard = C;

			}
		}
		if (lowCardFound && highCardFound)
			return new HandRecognitionResult(true, definingCard);
		else
			return new HandRecognitionResult(false, null);

	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		Suit S = this.recognizeHand(hand).getDefiningCard().getSuit();
		List<Integer> indexes = hand.getCardIndex(getLowCard(), S);
		indexes.addAll(hand.getCardIndex(getHighCard(), S));
		return new HoldCardsAction(indexes);
	}

}
