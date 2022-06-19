package src.java.poker.app.hand.recognition.count;

/**
 * 
 * To Recognize if hand has three of similar value cards
 *
 */
public class ThreeOfARecognizer extends OfAKindRecognizer {
	/**
	 * public Constructor that sets handName to "THREE OF A KIND", rewardMultiplier
	 * to 3 and count to 3
	 * 
	 */
	public ThreeOfARecognizer() {
		super("THREE OF A KIND", 3, 3);
	}

}
