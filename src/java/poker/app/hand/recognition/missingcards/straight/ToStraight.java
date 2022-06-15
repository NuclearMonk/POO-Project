package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

public abstract class ToStraight extends HandRecognizer {

    protected ToStraight(String handName, int rewardMultiplier) {
        super(handName, rewardMultiplier);
    }

    public static List<Integer> getGaps(Hand hand) {
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

            } else {
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
