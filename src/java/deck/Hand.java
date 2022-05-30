package src.java.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand extends Deck {
	public Hand(List<Card> list) {
		if (list.size() != 5)
			throw new IllegalArgumentException("Hands should be only 5 cards");
		this.cards.addAll(list);
	}

	public void replaceCards(Deck deck1, int a[]) {

		if (a.length > 5 || Arrays.stream(a).max().getAsInt() > 5 || Arrays.stream(a).min().getAsInt() < 1)
			throw new IllegalArgumentException("Illigal indexes");
		int numberOfCards = 5 - a.length;
		ArrayList<Card> cardsFromDeck = new ArrayList<Card>(deck1.drawCard(numberOfCards));
		boolean replace = true;
		for (int i = 1; i < 6; i++)

		{
			replace = true;
			for (int element : a) {
				if (element == i) {
					replace = false;
				}
			}
			if (replace)
				this.cards.set((i - 1), cardsFromDeck.remove(0));
		}

	}

	@Override
	public String toString() {
		return "player's hand [" + this.cards + "]";
	}
}
