package src.java.poker.app.hand.recognition.missingcards.straight;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
/**
 * 
 * Three To Royal Flush recognizer
 *
 */
public class ThreeToRoyalFlush extends ThreeToStraightFlush{
	/**
	 * recognize if the hand has a Royal flush that misses two cards
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
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
