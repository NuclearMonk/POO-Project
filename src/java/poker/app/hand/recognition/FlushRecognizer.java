package src.java.poker.app.hand.recognition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class FlushRecognizer extends HandRecognizer {
	public FlushRecognizer() {
		super("FLUSH", 7);
	}

	/**
	 * Recognizing Where all 5 cards same the same suit
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		Card firstCard = hand.getCardByIndex(0); // get the first card of the hand
		Suit suit = firstCard.getSuit(); // get the suit of the first card
		List<Card> foundCards = hand.findCards(suit); // get all the cards that have the said suit in hand
		if (foundCards.size() != Hand.HAND_SIZE) { // compare the length of the list to the hand size
			return new HandRecognitionResult(false, null); // not all cards in hand have the same suit
		}
		// all cards in hand have the same suit so we need to get the best card in hand
		Collections.sort(foundCards); // sort the hand from lowest tom highest
		Collections.reverse(foundCards); // reverse the hant to get highest to lowest
		Card definingCard = foundCards.get(0); // get the highest card
		return new HandRecognitionResult(true, definingCard); // output the result
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}

}
