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

	// public Hand(List<Card> list) {
	// if (list.size() != 5)
	// throw new IllegalArgumentException("Hands should be only 5 cards");
	// this.cards.addAll(list);
	// }

	// public void replaceCards(Deck deck1, int a[]) {

	// if (a.length > 5 || Arrays.stream(a).max().getAsInt() > 5 ||
	// Arrays.stream(a).min().getAsInt() < 1)
	// throw new IllegalArgumentException("Illegal indexes");
	// int numberOfCards = 5 - a.length;
	// ArrayList<Card> cardsFromDeck = new
	// ArrayList<Card>(deck1.drawCard(numberOfCards));
	// boolean replace = true;
	// for (int i = 1; i < 6; i++)

	// {
	// replace = true;
	// for (int element : a) {
	// if (element == i) {
	// replace = false;
	// }
	// }
	// if (replace)
	// this.cards.set((i - 1), cardsFromDeck.remove(0));
	// }

	// }

	@Override
	public String toString() {
		return "Hand = " + Arrays.toString(this.cards);
	}

	private static boolean isValidIndex(int index) {
		return index >= 0 && index < HAND_SIZE;
	}
}
