package src.java.poker.app.hand.recognition.count;

import src.java.poker.card.Card;
/**
 * 
 * Recognize if hand has Four 5s up to Kings
 *
 */
public class Four5KRecognizer extends RangedFourOfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "FOUR 5-K" and
	 * rewardsMultiplayer to 50 the lowValue to 5 and highValue to 13
	 */
	public Four5KRecognizer() {
		super("FOUR 5-K", 50, 5, Card.KING);

	}
}
