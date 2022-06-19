package src.java.poker.app.hand.recognition.sequence;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
/**
 * 
 * Straight Flush Recognizer
 *
 */
public class StraightFlushRecognizer extends StraightRecognizer {

	protected static final FlushRecognizer recognizer = new FlushRecognizer();

	/**
	 * public constructor that set handName to "STRAIGHT FLUSH" and rewardMultiplier
	 * to 50
	 */
	public StraightFlushRecognizer() {
		super("STRAIGHT FLUSH", 50);
	}
	/**
	 * protected constructor
	 * @param handName to give for the hand
	 * @param rewardMultiplier equal to the factor that the bet is multiplay by
	 */

	protected StraightFlushRecognizer(String handName, int rewardMultiplier) {
		super(handName, rewardMultiplier);
	}
	/**
	 * recognize if the hand has "STRAIGHT FLUSH"
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (!result.isResult())
			return result;
		if (recognizer.recognizeHand(hand).isResult()) {
			return result;
		}
		return new HandRecognitionResult(false, null);
	}

}
