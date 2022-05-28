package src.java.deck;

public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String shorthand;

    private Suit(String shorthand)
    {
        this.shorthand = shorthand;
    }

    public String getShorthand() {
        return shorthand;
    }

}
