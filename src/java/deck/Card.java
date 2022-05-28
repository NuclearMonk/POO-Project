package src.java.deck;

public class Card {

    private final int value;
    private final Suit suit;

    public static final int ACE = 1;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    

    public Card(int value, Suit suit) {
        if(value <=0|| value >13 )
        {
            throw new  IllegalArgumentException("Value is Invalid");
        }
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + value;
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
        Card other = (Card) obj;
        if (suit != other.suit)
            return false;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String output = "";
        switch (value) {
            case ACE:
                output += "A";
                break;
            case TEN:
                output += "T";
                break;
            case JACK:
                output += "J";
                break;
            case QUEEN:
                output += "Q";
                break;
            case KING:
                output += "K";
                break;
            default:
            output += value;
                break;
        }
        return output + suit.getShorthand();
    }

}
