package src.java.deck;

public class Card {
    private static final String STR_IS_INVALID = "Str is Invalid";
    private final int value;
    private final Suit suit;

    public static final int ACE = 1;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public Card(int value, Suit suit) {
        if (value <= 0 || value > 13) {
            throw new IllegalArgumentException("Value is Invalid");
        }
        this.value = value;
        this.suit = suit;
    }

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
