package src.java.poker.deck;

public class OutOfCardsException extends RuntimeException{
/**
 * 
 * @param string
 */
    public OutOfCardsException(String string) {
        super(string);
    }
    
}
