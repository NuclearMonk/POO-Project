package src.java.poker.app.hand.recognition.count;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;

/**
 * 
 * Recognizing Where there a number of matched value cards with values between
 * two values that is equal to the count Attribute
 */
public class RangedFourOfAKindRecognizer extends FourOfAKindRecognizer {
	private int lowValue;
	private int highValue;

	/**
	 * public Constructor that set count to 4
	 * 
	 * @param handName
	 * @param rewardMultiplier
	 * @param count
	 */
	public RangedFourOfAKindRecognizer(String handName, int rewardMultiplier, int lowValue, int highValue) {
		super(handName, rewardMultiplier, 4);
		this.lowValue = lowValue;
		this.highValue = highValue;
	}

	/**
	 * Recognizing Where there a number of matched value cards with values between
	 * two values that is equal to the count Attribute
	 * 
	 * @return HandRecognitionResult
	 * @param hand to check
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = super.recognizeHand(hand);
		if (!result.isResult())
			return result;
		if (result.getDefiningCard().getValue() < lowValue || result.getDefiningCard().getValue() > highValue)
			return new HandRecognitionResult(false, null);
		return result;
	}

}
