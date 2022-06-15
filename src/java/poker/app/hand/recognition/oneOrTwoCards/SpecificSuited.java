package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class SpecificSuited extends HandRecognizer {
	final int  lowCard;
	final int highCard;

	protected SpecificSuited(String handName,int highCard, int lowCard) {
		super(handName,0);
		this.highCard = highCard;
		this.lowCard = lowCard;
	}
	public int getLowCard() {
		return lowCard;
	}
	public int getHighCard() {
		return highCard;
	}
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		Suit S = this.recognizeHand(hand).getDefiningCard().getSuit();
		List<Integer> indexes = hand.getCardIndex(getLowCard(),S);
		indexes.addAll(hand.getCardIndex(getHighCard(), S));
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		ArrayList<Suit> highCardSuit = new ArrayList<Suit>();
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == this.lowCard || C.getValue() == this.highCard)
				highCardSuit.add(C.getSuit());
		}
		for (Suit s : Suit.values()) {
			if (Collections.frequency(highCardSuit, s) == 2) {
				Card definingCard = new Card(Card.QUEEN, s);
				return new HandRecognitionResult(true, definingCard);
			}
		}
		return new HandRecognitionResult(false, null);

	}


}
