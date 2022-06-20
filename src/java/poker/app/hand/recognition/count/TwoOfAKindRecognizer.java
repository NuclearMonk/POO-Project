package src.java.poker.app.hand.recognition.count;

public class TwoOfAKindRecognizer extends OfAKindRecognizer {
	/**
	 * public Constructor of the Class that set count to 2
	 * 
	 * @param handName         to be given to the hand
	 * @param rewardMultiplier equal to the factor that the bet is multiply by
	 * 
	 */
	protected TwoOfAKindRecognizer(String handName, int rewardMultiplier) {
		super(handName, rewardMultiplier, 2);
	}

}
