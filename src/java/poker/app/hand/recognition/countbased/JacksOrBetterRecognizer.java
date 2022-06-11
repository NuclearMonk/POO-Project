package src.java.poker.app.hand.recognition.countbased;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class JacksOrBetterRecognizer extends TwoOfAKindRecognizer {

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        HandRecognitionResult result = super.recognizeHand(hand);
        if (!result.isResult())
            return result;
        if (result.getDefiningCard().getValue() < Card.JACK && result.getDefiningCard().getValue() != Card.ACE)
            return new HandRecognitionResult(false, null);
        return result;
    }

}
