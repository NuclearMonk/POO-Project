package src.java.poker.app.hand.recognition.sequence;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class RoyalFlushRecognizer extends StraightFlushRecognizer {

    public RoyalFlushRecognizer() {
        super("ROYAL FLUSH", 250);
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        HandRecognitionResult result = super.recognizeHand(hand);
        if (!result.isResult())
            return result;
        if (result.getDefiningCard().getValue() == Card.ACE) {
            return result;
        }
        return new HandRecognitionResult(false, null);
    }

}
