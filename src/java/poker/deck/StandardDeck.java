package src.java.poker.deck;

import java.util.Collections;
import java.util.List;

import src.java.poker.card.Card;
import src.java.poker.card.Suit;

/**
 * A Standard 52 Card Deck
 */
public class StandardDeck extends Deck {

	/**
	 * public Constructs a new Standard Deck, A deck ordered by suit and suits
	 * ordered in alphabetical order
	 */
	public StandardDeck() {
		for (Suit suit : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(i, suit);
				this.cards.add(card);
			}
		}
		this.shuffle();
	}

	/**
	 * @param number Of Cards to draw
	 * @return List<Card> thats has been drawn
	 * @throws OutOfCardsException if the is empty
	 */
	@Override
	public List<Card> drawCards(int numberOfCards) throws OutOfCardsException {
		List<Card> drawnCards = super.drawCards(numberOfCards);
		this.cards.addAll(drawnCards);// storing the drawn card at the end of the deck to avoid having to create a new
		// object
		return drawnCards;
	}

	/**
	 * Shuffling the cards
	 */
	@Override
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
}
