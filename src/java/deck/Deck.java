package src.java.deck;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<>();

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

	public List<Card> drawCard(int numberOfCards) {
		if (this.numberOfRemainingCards() - numberOfCards < 0)
			throw new IllegalArgumentException("Deck does not have enough cards");
		ArrayList<Card> drawnCards = new ArrayList<>();
		for (int i = 0; i < numberOfCards; i++) {
			drawnCards.add(this.cards.get(0));
			this.cards.remove(0);
		}
		return drawnCards;
	}

	@Override
	public String toString() {
		return "Deck=" + cards;
	}

	public int numberOfRemainingCards() {
		return this.cards.size();
	}

}
