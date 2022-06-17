package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class FourToOutsideStraight extends FourToStraight {

    public FourToOutsideStraight() {
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        HandRecognitionResult superResult = super.recognizeHand(hand);
        if(superResult.isResult())
        {
            List<Integer> straightMembers = getStraightMembers(hand);
            for (int i = 1; i < straightMembers.size(); i++) {
                if(straightMembers.get(i-1)-straightMembers.get(i)!=-1)
                {
                    return new HandRecognitionResult(false, null);
                }
            }
            if(straightMembers.contains(Card.ACE))
            {
                return new HandRecognitionResult(false, null);
            }
            return superResult;
        }
        return superResult;
    }
    
}
