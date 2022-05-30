package src.java.deck;

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
}
