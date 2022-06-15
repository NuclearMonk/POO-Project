package src.java.poker.app.hand.recognition.missingcards.straight;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class FourToRoyalFlush extends FourToStraightFlush {

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        HandRecognitionResult result = super.recognizeHand(hand);
        if (!result.isResult())
            return result;
        if (result.getDefiningCard().getValue() == Card.TEN) {
            return result;
        }
        return new HandRecognitionResult(false, null);
    }

}
