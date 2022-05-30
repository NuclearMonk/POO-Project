package src.java.deck;

/**
 * 
 */
public enum Suit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private final char shorthand;

    private Suit(char shorthand) {
        this.shorthand = shorthand;
    }

    /**
     * 
     * @return The Shorthand char that represents the Suit
     */
    public char getShorthand() {
        return shorthand;
    }

    /**
     * Convert a char to a valid suit
     * @param character the character to be converted
     * @return the suit
     * @throws IllegalArgumentException if the character is not shorthand for a known suit
     */
    public static Suit shorthandToSuit(char character){
        for (Suit suit : Suit.values()) {
            if (suit.shorthand == character) {
                return suit;
            }
        }
        throw new IllegalArgumentException("character is invalid, not a shorthand for a valid suit");
    }

}
