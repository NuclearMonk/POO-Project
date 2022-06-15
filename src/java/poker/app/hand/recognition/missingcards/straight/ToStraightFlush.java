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
        HandRecognitionResult superResult = super.recognizeHand(hand);
        if (!superResult.isResult()) {
            return superResult;
        }
        List<Integer> members = getStraightMembers(hand);
        for (Card card : hand.findCards(members.get(0))) {
            int suitCount = 1;
            for (int i = 1; i < members.size(); i++) {
                if (hand.findCards(members.get(i), card.getSuit()).size() > 0) {
                    suitCount++;
                }
            }
            if (suitCount >= toAStraightCount) {
                return new HandRecognitionResult(true, superResult.getDefiningCard());
            }
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
}
