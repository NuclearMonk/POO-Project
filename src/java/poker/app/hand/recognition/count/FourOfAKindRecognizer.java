package src.java.poker.app.hand.recognition.count;
/**
 * 
 * To recognize any four cards with similar values in a hand
 *
 */
public abstract class FourOfAKindRecognizer extends OfAKindRecognizer{

	/**
	 * protected Constructor of the class that set the count to 4
	 * @param handName the name of the hand 
	 * @param rewardMultiplier the multiplier for successfully achieving the hand 
	 */
    protected FourOfAKindRecognizer(String handName, int rewardMultiplier) {
        super(handName, rewardMultiplier, 4);
    }
    
}
