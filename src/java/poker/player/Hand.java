package src.java.poker.player;

import java.util.ArrayList; // Import the ArrayList Class
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import src.java.poker.card.Card; //Import the card class 
import src.java.poker.deck.Deck;
import src.java.poker.deck.OutOfCardsException;

/**
 * A Class that is a hand of 5 cards
 */

public class Hand {
	/**
	 * Hand size is final equal to 5
	 */
	public static final int HAND_SIZE = 5;
	private Card[] cards;

	/**
	 * Public Constructor of a hand from a Deck
	 * 
	 * @param deck
	 * @throws NullPointerException
	 * @throws OutOfCardsException
	 */
	public Hand(Deck deck) throws NullPointerException, OutOfCardsException {
		if (null == deck)
			throw new NullPointerException("deck is invalid");
		this.cards = new Card[HAND_SIZE];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = deck.draw();
		}
	}

	/**
	 * Method to replace one card using its indexes
	 * 
	 * @param index   of cards need to be replace
	 * @param newCard the card to be replaced with
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException
	 */

	public void replaceCards(int index, Card newCard) {

		if (!isValidIndex(index))
			throw new IndexOutOfBoundsException("index is out of bounds");
		if (null == newCard)
			throw new NullPointerException("newCard is invalid");
		this.cards[index-1] = newCard;
	}

	/**
	 * Method to replace cards using list of their indexes, and a Deck
	 * 
	 * @param deck    to deal cards from
	 * @param indexes of cards to be replaced
	 */
	public void replaceCards(Deck deck, List<Integer> indexes) {
		List<Card> drawnCards = deck.drawCards(indexes.size());
		replaceCards(indexes, drawnCards);
	}

	/**
	 * Method to replace cards using list of their indexes, and a list of cards
	 * 
	 * @param indexes
	 * @param cards
	 */
	private void replaceCards(List<Integer> indexes, List<Card> cards) {
		Iterator<Integer> indexIterator = indexes.iterator();
		Iterator<Card> cardIterator = cards.iterator();
		while (indexIterator.hasNext() && cardIterator.hasNext()) {
			replaceCards(indexIterator.next(), cardIterator.next());
		}
	}

	/**
	 *@return String
	 */
	@Override
	public String toString() {
		String output = "";
		for (Card card : this.cards) {
			output += card + " ";
		}
		return output.trim();
	}
	/**
	 * Private method to check whether the index is valid or not 
	 * @param index
	 * @return
	 */

	private static boolean isValidIndex(int index) {
		return index > 0 && index <= HAND_SIZE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cards);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (!Arrays.equals(cards, other.cards))
			return false;
		return true;
	}
}
