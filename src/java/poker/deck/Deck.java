package src.java.poker.deck;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.List;
import java.util.Random;
import src.java.poker.card.Card;

/**
 * A Class that holds a deck of cards
 */
public abstract class Deck {
	protected ArrayList<Card> cards = new ArrayList<>();

	/**
	 * Shuffles the deck, in a random order, seed is generated at runtime
	 */
	public abstract void shuffle();

	/**
	 * Shuffles the deck, in a random order, with the provided random generator
	 * 
	 * @param random the random generator
	 */
	public void shuffle(Random random) {
		Collections.shuffle(this.cards, random);
	}

	/**
	 * Sorts the deck using the collection sort method, and the Card's compareTo
	 * method
	 */
	public void sort() {
		Collections.sort(this.cards);
	}

	/**
	 * @param numberOfCards The number of cards to be drawn
	 * @return List<Card>
	 */
	public List<Card> drawCards(int numberOfCards) throws OutOfCardsException {
		if (this.numberOfRemainingCards() - numberOfCards < 0)
			throw new OutOfCardsException("Deck does not have enough cards");
		ArrayList<Card> drawnCards = new ArrayList<>();
		for (int i = 0; i < numberOfCards; i++) {
			drawnCards.add(draw());
		}
		return drawnCards;
	}

	protected Card draw() throws OutOfCardsException {
		if (numberOfRemainingCards() <= 0)
			throw new OutOfCardsException("Deck does not have enough cards");
		return this.cards.remove(0);
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "Deck=" + cards;
	}

	/**
	 * @return int the number of cards still in the deck
	 */
	public int numberOfRemainingCards() {
		return this.cards.size();
	}

}
