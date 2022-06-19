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
        this.shuffle();
    }

    @Override
    public List<Card> drawCards(int numberOfCards) throws OutOfCardsException {
        return super.drawCards(numberOfCards);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    @Override
    protected Card draw() throws OutOfCardsException {
        Card card = super.draw();
        cards.add(card);
        return card;
    }
}
