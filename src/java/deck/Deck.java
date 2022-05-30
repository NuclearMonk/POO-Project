package src.java.deck;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.List;

public abstract class Deck {
	protected ArrayList<Card> cards = new ArrayList<>();

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public void sort() {
		Collections.sort(this.cards);
	}

	
	/** 
	 * @param numberOfCards
	 * @return List<Card>
	 */
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

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Deck=" + cards;
	}

	
	/** 
	 * @return int
	 */
	public int numberOfRemainingCards() {
		return this.cards.size();
	}

}
