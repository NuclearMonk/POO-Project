package src.java.poker.deck;

import java.util.List;

import src.java.poker.card.Card;
import src.java.poker.card.Suit;

/**
 * A Standard 52 Card Deck
 */
public class StandardDeck extends Deck {

    /**
     * Constructs a new Standard Deck, A deck ordered by suit and suits ordered in
     * alphabetical order
     */
    public StandardDeck() {
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(i, suit);
                this.cards.add(card);
            }
        }
    }

    @Override
    public List<Card> drawCards(int numberOfCards) throws OutOfCardsException {
        List<Card> drawnCards = super.drawCards(numberOfCards);
        cards.addAll(drawnCards);//storing the drawn card at the end of the deck to avoid having to create a new object
        return drawnCards;
    }
}
