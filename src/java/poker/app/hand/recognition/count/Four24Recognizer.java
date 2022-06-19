package src.java.poker.app.hand.recognition.count;

/**
 * 
 * Recognize if hand has Four 2s,3s or 4s 
 *
 */
public class Four24Recognizer extends RangedFourOfAKindRecognizer {
	/**
	 * Public Constructor of the class that set handName to "FOUR 2-4" and
	 * rewardsMultiplayer to 80 the lowValue to 2 and highValue to 4
	 */

	public Four24Recognizer() {
		super("FOUR 2-4", 80, 2, 4);

	}
}
