package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class ToStraightFlush extends ToStraight {

    public ToStraightFlush(int toAStraightCount) {
        super(toAStraightCount);
    }

    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        List<Card> cards = getStraightFlushMembers(hand);
        if (cards.size() >= toAStraightCount) {
            return new HandRecognitionResult(true, cards.get(0));
        }
        return new HandRecognitionResult(false, null);
    }

    @Override
    public PlayerAction getAdviceAction(Hand hand) {
        List<Card> cards = getStraightFlushMembers(hand);
        ArrayList<Integer> indexes = new ArrayList<>();
        for (Card card : cards) {
            indexes.add(hand.getCardIndex(card.getValue(), card.getSuit()).get(0));
        }
        return new HoldCardsAction(indexes);
    }

    protected List<Card> getStraightFlushMembers(Hand hand) {
        List<Card> finalList = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (int value = 0; value < Card.TEN; value++) {
                ArrayList<Card> currentCandidate = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    List<Card> r = hand.findCards(value + i, suit);
                    if (!r.isEmpty()) {
                        currentCandidate.addAll(r);
                    }
                }
                if (currentCandidate.size() >= toAStraightCount) {
                    finalList = currentCandidate;
                }
            }
            ArrayList<Card> currentCandidate = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                List<Card> r = hand.findCards(Card.TEN + i, suit);
                if (!r.isEmpty()) {
                    currentCandidate.addAll(r);
                }
            }
            List<Card> r = hand.findCards(Card.ACE, suit);
            if (!r.isEmpty()) {
                currentCandidate.addAll(r);
            }
            if (currentCandidate.size() >= toAStraightCount) {
                finalList = currentCandidate;
            }
        }
        return finalList;
    }
}
