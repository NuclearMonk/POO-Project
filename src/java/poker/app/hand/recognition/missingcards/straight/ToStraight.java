package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

public abstract class ToStraight extends HandRecognizer {
    private final int toAStraightCount;

    public ToStraight(String handName, int rewardMultiplier, int toAStraightCount) {
        super(handName, rewardMultiplier);
        this.toAStraightCount = toAStraightCount;
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        List<Integer> values = getStraightMembers(hand);
        if (values.size() == toAStraightCount) {
            return new HandRecognitionResult(true, hand.findCards(values.get(0)).get(0));
        }
        return new HandRecognitionResult(false, null);
    }

    public static List<Integer> getStraightMembers(Hand hand) { // TODO Make This protected, it's public to allow
                                                                // testing
        int highestToStraightCount = 0;
        ArrayList<Integer> valuesWeHave = new ArrayList<>();
        for (int cardValue = Card.ACE; cardValue <= Card.TEN; cardValue++) {
            int toStraightCount = 0;
            ArrayList<Integer> runningValues = new ArrayList<>();
            if (cardValue != Card.TEN) {
                for (int straightValueOffset = 0; straightValueOffset < 5; straightValueOffset++) {
                    if (!hand.findCards(cardValue + straightValueOffset).isEmpty())// we found a gap
                    {
                        toStraightCount++;
                        runningValues.add(cardValue + straightValueOffset);
                    }
                }

            } else { /* Special case that checks for cards missing to a TJQKA straight */
                for (int straightValueOffset = 0; straightValueOffset < 4; straightValueOffset++) {
                    if (!hand.findCards(cardValue + straightValueOffset).isEmpty())// we found a gap
                    {
                        toStraightCount++;
                        runningValues.add(cardValue + straightValueOffset);
                    }
                }
                if (!hand.findCards(Card.ACE).isEmpty())// we found a gap
                {
                    toStraightCount++;
                    runningValues.add(Card.ACE);
                }
            }
            if (toStraightCount >= highestToStraightCount) {
                valuesWeHave = runningValues;
                highestToStraightCount = toStraightCount;
            }
        }
        return valuesWeHave;
    }

}
