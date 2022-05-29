package src.java.deck;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(i, suit);
				this.cards.add(card);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public ArrayList<Card> drawCard(int N) {
		if (this.numberOfRemainingCards() - N < 0)
			throw new IllegalArgumentException("Deck does not have enough cards");
		ArrayList<Card> drawedCards = new ArrayList<Card>();
		for (int i = 0; i < N; i++) {
			drawedCards.add(this.cards.get(0));
			this.cards.remove(0);
		}
		return drawedCards;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

	public int numberOfRemainingCards() {
		return this.cards.size();
	}

}
