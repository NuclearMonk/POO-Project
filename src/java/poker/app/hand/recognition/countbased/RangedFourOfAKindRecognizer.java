package src.java.poker.app.hand.recognition.countbased;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class RangedFourOfAKindRecognizer extends FourOfAKindRecognizer {
    private int lowValue;
    private int highValue;

    public RangedFourOfAKindRecognizer(int lowValue, int highValue) {
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
