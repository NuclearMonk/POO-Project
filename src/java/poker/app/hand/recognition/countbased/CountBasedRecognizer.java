package src.java.poker.app.hand.recognition.countbased;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;

public abstract class CountBasedRecognizer extends HandRecognizer{
    protected int count;

    protected CountBasedRecognizer(int count) {
        this.count = count;
    }

    @Override
    public Boolean recognizeHand(Hand hand) {
        Boolean result = false;
        for (int i = 0; i < Hand.HAND_SIZE; i++) {
            Integer handCount = hand.findCards(hand.getCardByIndex(i).getValue()).size();
            if(handCount==this.count) result = true;
            else if(handCount>=this.count)return false;
            else if(handCount !=1 && handCount<count)return false;
        }
        return result;
    }
}
