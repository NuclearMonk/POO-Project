package src.java.poker.card;

/**
 * Class for a standard playing card
 */
public class Card implements Comparable<Card> {

    private static final String STR_IS_INVALID = "Str is Invalid"; // used in multiple places so a constant was created
    /**REGEX Expression that matches valid card string representations */
    public static final String CARD_REGEX = "[ATJQK2-9][CDHS]";

    private final int value; /* The card's face value */
    private final Suit suit; /* The card's suit */

    /*
     * Constants to make handling weird cards easier
     */
    /** ACE Card */
    public static final int ACE = 1;
    /** 10 Card */
    public static final int TEN = 10;
    /** JACK Card */
    public static final int JACK = 11;
    /** QUEEN Card */
    public static final int QUEEN = 12;
    /** KING Card */
    public static final int KING = 13;

    /**
     * Constructs a new Card object with the specified object with the specified
     * value and suit
     * 
     * @param value the face value of the Card
     * @param suit  One of the valid Suits
     * @throws IllegalArgumentException in case the value is outside the 1-13 range
     */
    public Card(int value, Suit suit) {
        if (value <= 0 || value > 13) {
            throw new IllegalArgumentException("Value is Invalid");
        }
        this.value = value;
        this.suit = suit;
    }

    /**
     * Constructs a new Card object from a string
     * 
     * @param str the source string
     * @throws IllegalArgumentException if the string doesn't match
     *                                  ^[ATJQK2-9][CDHS]$
     */
    public Card(String str) {
        if (null == str || str.length() != 2) {
            throw new IllegalArgumentException(STR_IS_INVALID);
        } else {
            switch (str.charAt(0)) {
                case 'A':
                    this.value = ACE;
                    break;
                case '2':
                    this.value = 2;
                    break;
                case '3':
                    this.value = 3;
                    break;
                case '4':
                    this.value = 4;
                    break;
                case '5':
                    this.value = 5;
                    break;
                case '6':
                    this.value = 6;
                    break;
                case '7':
                    this.value = 7;
                    break;
                case '8':
                    this.value = 8;
                    break;
                case '9':
                    this.value = 9;
                    break;
                case 'T':
                    this.value = TEN;
                    break;
                case 'J':
                    this.value = JACK;
                    break;
                case 'Q':
                    this.value = QUEEN;
                    break;
                case 'K':
                    this.value = KING;
                    break;
                default:
                    throw new IllegalArgumentException(STR_IS_INVALID);
            }
            try {
                this.suit = Suit.shorthandToSuit(str.charAt(1));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(STR_IS_INVALID);
            }
        }
    }

    /**
     * @return the card's suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the card's value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + value;
        return result;
    }

    /**
     * @param obj the object to compare with
     * @return boolean wether or not the object is the same
     */
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

    /**
     * @return String a string that matches ^[ATJQK2-9][CDHS]$
     */
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

    /**
     * @param otherCard the other Card to be compared with
     * @return int positive if bigger, negative if smaller
     */
    @Override
    public int compareTo(Card otherCard) {
        int compValue = this.value - otherCard.value;
        if (compValue == 0)
            return 0;
        if (this.value == ACE)
            return 1;
        if (otherCard.value == ACE)
            return -1;
        return compValue;
    }

}
