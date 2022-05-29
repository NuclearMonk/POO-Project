package src.java.deck;

public enum Suit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private final char shorthand;

    private Suit(char shorthand) {
        this.shorthand = shorthand;
    }

    public char getShorthand() {
        return shorthand;
    }

    public static Suit shorthandToSuit(char character) {
        for (Suit suit : Suit.values()) {
            if(suit.shorthand == character)
            {
                return suit;
            }
        }
        throw new IllegalArgumentException("character is invalid, not a shorthand for a valid suit");
    }

}
