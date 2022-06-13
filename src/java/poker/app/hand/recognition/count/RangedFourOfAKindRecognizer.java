package src.java.poker.app.hand.recognition.count;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;

public class RangedFourOfAKindRecognizer extends FourOfAKindRecognizer {
    private int lowValue;
    private int highValue;


    public RangedFourOfAKindRecognizer(String handName, int rewardMultiplier, int lowValue, int highValue) {
        super(handName, rewardMultiplier, 4);
        this.lowValue = lowValue;
        this.highValue = highValue;
    }


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
