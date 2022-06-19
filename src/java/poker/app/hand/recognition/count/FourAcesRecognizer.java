package src.java.poker.app.hand.recognition.count;
import src.java.poker.card.Card;
/**
 * 
 * Recognize if hand has Four Aces 
 *
 */
public class FourAcesRecognizer extends RangedFourOfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "FOUR 2-4" and
	 * rewardsMultiplayer to 160 the lowValue to 1 and highValue to 1
	 */
    public FourAcesRecognizer() {
        super("FOUR ACES", 160, Card.ACE, Card.ACE);
    }


}
