package src.java.poker.app.hand.recognition.missingcards.flush;

/**
 * A recognizer that matches when the hand contains has 4 cards with a  matching suit
 */
public class FourToFlush extends ToFlush {

	/**
	 * Public Constructor of the class that set handName to "Four To Flush" and
	 * rewardsMultiplayer to 0 the count to 4 
	 */
	public FourToFlush() {
		super("Four To Flush", 0, 4);
	}

}
