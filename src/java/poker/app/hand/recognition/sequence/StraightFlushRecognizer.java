package src.java.poker.app.hand.recognition.sequence;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognitionResult;

public class StraightFlushRecognizer extends StraightRecognizer {

    protected static final FlushRecognizer recognizer = new FlushRecognizer();

    public StraightFlushRecognizer() {
        super("STRAIGHT FLUSH", 50);
    }

    protected StraightFlushRecognizer(String handName, int rewardMultiplier) {
        super(handName, rewardMultiplier);
    }

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
