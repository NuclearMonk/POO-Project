package src.java.poker.app.hand.recognition.sequence;

import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

public class StraightRecognizer extends HandRecognizer {

    public StraightRecognizer() {
        super("STRAIGHT",5);
    }

    protected StraightRecognizer(String handName, int rewardMultiplier) {
        super(handName, rewardMultiplier);
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        List<Card> handAsList = hand.cardsAsList();
        Collections.sort(handAsList);
        Card firstCard = handAsList.get(0);
        if (handAsList.get(handAsList.size() - 1).getValue() == Card.ACE) { // we can either have a TJQKA or an A2345
            if (firstCard.getValue() == 2 || firstCard.getValue() == 10) {
                int lastValue = firstCard.getValue();
                for (int i = 1; i < handAsList.size() - 1; i++) {
                    if (handAsList.get(i).getValue() - lastValue != 1) // if they differ in less or more than one to the
                                                                       // last card
                    {
                        return new HandRecognitionResult(false, null);
                    }
                    lastValue = handAsList.get(i).getValue();
                }
                if (firstCard.getValue() == 2) {
                    return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 2));
                }
                if (firstCard.getValue() == 10) {
                    return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 1));
                }
                return new HandRecognitionResult(false, null);
            }
        } else if (firstCard.getValue() >= Card.JACK)// THERE ARE NO STRAIGHTS THAT START WITH JACK AS THE LOWEST CARD

        {
            return new HandRecognitionResult(false, null);
        } else {
            int lastValue = firstCard.getValue();
            for (int i = 1; i < handAsList.size(); i++) {
                if (handAsList.get(i).getValue() - lastValue != 1) // if they differ in less or more than one to the
                                                                   // last
                                                                   // card
                {
                    return new HandRecognitionResult(false, null);
                }
                lastValue = handAsList.get(i).getValue();
            }
            return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 1));
        }
        return new HandRecognitionResult(false, null);
    }

}
