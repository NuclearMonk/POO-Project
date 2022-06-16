package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class ToStraightFlush extends ToStraight {
    
    public ToStraightFlush(int toAStraightCount) {
        super(toAStraightCount);
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        List<Integer> values = getStraightMembers(hand);
        if (values.size() >= toAStraightCount) {
            return new HandRecognitionResult(true, hand.findCards(values.get(0)).get(0));
        }
        return new HandRecognitionResult(false, null);
    }

    @Override
    public PlayerAction getAdviceAction(Hand hand) {
        List<Integer> values = getStraightMembers(hand);
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        for (Card card : hand.findCards(values.get(0))) {
            for (int i = 1; i < values.size(); i++) {
                if (hand.findCards(values.get(i), card.getSuit()).size() > 0) {
                    indexes.add(i);
                }
            }
        }
        return new HoldCardsAction(indexes);
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
            if (toStraightCount >= highestToStraightCount && areIndexesAFlush(hand, runningValues)) {
                valuesWeHave = runningValues;
                highestToStraightCount = toStraightCount;
            }
        }
        return valuesWeHave;
    }
    
    private static Boolean areIndexesAFlush(Hand hand, List<Integer> values)
    {
        for (Card card : hand.findCards(values.get(0))) {
            int suitCount = 1;
            for (int i = 1; i < values.size(); i++) {
                if (!hand.findCards(values.get(i), card.getSuit()).isEmpty()) {
                    suitCount++;
                }
            }
            if (suitCount == values.size()) {
                return true;
            }
        }
        return false;
    }
}
