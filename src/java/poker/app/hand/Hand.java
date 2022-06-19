package src.java.poker.app.hand;

import java.util.ArrayList; // Import the ArrayList Class
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import src.java.poker.card.Card; //Import the card class 
import src.java.poker.card.Suit;
import src.java.poker.deck.Deck;
import src.java.poker.deck.OutOfCardsException;

public class Hand {
	/**
	 * Hand size is final equal to 5
	 */
	public static final int HAND_SIZE = 5;
	private Card[] cards;

	/**
	 * Public Constructor of a hand from a Deck
	 * 
	 * @param deck to draw cards from
	 * @throws NullPointerException
	 * @throws OutOfCardsException
	 */
	public Hand(Deck deck) throws NullPointerException, OutOfCardsException {
		if (null == deck)
			throw new NullPointerException("deck is null");
		this.cards =  deck.drawCards(HAND_SIZE).toArray(new Card[0]);
	}

	/**
	 * Public Constructor of a hand from a String
	 * 
	 * @param string
	 * @throws NullPointerException
	 */
	public Hand(String string) throws NullPointerException {
		if (null == string) {
			throw new NullPointerException("string is null");
		}
		this.cards = new Card[HAND_SIZE];
		String[] cardStrings = string.split("[ ]");
		if (cardStrings.length != HAND_SIZE)
			throw new IllegalArgumentException();
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card(cardStrings[i]);
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
		this.cards[index - 1] = newCard;
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
	 * @param indexes of the cards to be replaced
	 * @param cards   to replace cards with
	 */
	private void replaceCards(List<Integer> indexes, List<Card> cards) {
		Iterator<Integer> indexIterator = indexes.iterator();
		Iterator<Card> cardIterator = cards.iterator();
		while (indexIterator.hasNext() && cardIterator.hasNext()) {
			replaceCards(indexIterator.next(), cardIterator.next());
		}
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (Card card : this.cards) {

			output.append(card + " ");
		}
		return output.toString().trim();
	}

	/**
	 * Private method to check whether the index is valid or not
	 * 
	 * @param index
	 * @return
	 */

	/**
	 * Check if an index is valid
	 * 
	 * @param index to be check
	 * @return boolean
	 */
	private static boolean isValidIndex(int index) {
		return index > 0 && index <= HAND_SIZE;
	}

	/**
	 *
	 * @param value to search for in a hand
	 * @return List<Card> that matches the value
	 */
	public List<Card> findCards(Integer value) {
		ArrayList<Card> returnValue = new ArrayList<>();
		for (Card card : this.cards) {
			if (card.getValue() == value) {
				returnValue.add(card);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param value the Value to be looked for in hand
	 * @return List<Integer> of the indexes of the cards that matches the value
	 *         giving by the value Parameter
	 */

	public List<Integer> getCardIndex(Integer value) {
		ArrayList<Integer> returnValue = new ArrayList<>();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (this.cards[i].getValue() == value) {
				returnValue.add(i);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param suit the suit to be looked for in the hand
	 * @return List<Integer>of the indexes of the cards that matches the Suit giving
	 *         by the suit parameter
	 */
	public List<Integer> getCardIndex(Suit suit) {
		ArrayList<Integer> returnValue = new ArrayList<>();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (this.cards[i].getSuit() == suit) {
				returnValue.add(i);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param value of the card to be searched for
	 * @param suit  the suit to be looked for in the hand
	 * @returnList<Integer> of the indexes of the cards that matches the giving
	 *                      parameters
	 */
	public List<Integer> getCardIndex(Integer value, Suit suit) {
		ArrayList<Integer> returnValue = new ArrayList<>();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (this.cards[i].getSuit() == suit && this.cards[i].getValue() == value) {
				returnValue.add(i);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param suit to be looked for in the hand
	 * @return List<Card> of the matching cards that matches the giving parameters
	 */

	public List<Card> findCards(Suit suit) {
		ArrayList<Card> returnValue = new ArrayList<>();
		for (Card card : this.cards) {
			if (card.getSuit().equals(suit)) {
				returnValue.add(card);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param value of the card to be searched for
	 * @param suit  of the card to be searched for
	 * @return List<Card> of the matching cards that matches the giving parameters
	 */
	public List<Card> findCards(Integer value, Suit suit) {
		ArrayList<Card> returnValue = new ArrayList<>();
		for (Card card : this.cards) {
			if (card.getSuit().equals(suit) && value == card.getValue()) {
				returnValue.add(card);
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @param index of the Card inside the hand
	 * @return Card that has the index
	 */

	public Card getCardByIndex(Integer index) {
		return cards[index];
	}

	/**
	 * 
	 * @return List<Card> of the hand
	 */
	public List<Card> cardsAsList() {
		return Arrays.asList(this.cards.clone());
	}

	/**
	 * @return hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cards);
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.\
	 * 
	 * @return boolean
	 */
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
