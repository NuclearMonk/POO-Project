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

public class KTSuited extends HandRecognizer {

	public KTSuited() {
		super("Suited King and Ten", 0);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		ArrayList<Suit> highCardSuit = new ArrayList<Suit>();
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == Card.KING || C.getValue() == Card.TEN)
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
