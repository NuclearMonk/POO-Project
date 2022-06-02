package src.java.poker.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import src.java.poker.card.Card;

public class Hand {
	public static final int HAND_SIZE = 5;
	private Card[] cards;

	public Hand(Deck deck) throws NullPointerException, OutOfCardsException {
		if (null == deck)
			throw new NullPointerException("deck is invalid");
		this.cards = new Card[HAND_SIZE];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = deck.draw();
		}
	}

	public void replaceCards(int index, Card newCard) {

		if (!isValidIndex(index))
			throw new IndexOutOfBoundsException("index is out of bounds");
		if (null == newCard)
			throw new NullPointerException("newCard is invalid");
		this.cards[index] = newCard;
	}

	public void replaceCards(Deck deck, List<Integer> indexes) {
		List<Card> drawnCards = deck.drawCards(indexes.size());
		replaceCards(indexes, drawnCards);
	}

	private void replaceCards(List<Integer> indexes, List<Card> cards) {
		Iterator<Integer> indexIterator = indexes.iterator();
		Iterator<Card> cardIterator = cards.iterator();
		while (indexIterator.hasNext() && cardIterator.hasNext()) {
			replaceCards(indexIterator.next(), cardIterator.next());
		}
	}

	@Override
	public String toString() {
		return "Hand = " + Arrays.toString(this.cards);
	}

	private static boolean isValidIndex(int index) {
		return index >= 0 && index < HAND_SIZE;
	}
}
