package src.java.poker.app.hand.recognition.count;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

public abstract class OfAKindRecognizer extends HandRecognizer{
    protected int count;



    protected OfAKindRecognizer(String handName, int rewardMultiplier, int count) {
        super(handName, rewardMultiplier);
        this.count = count;
    }
    
    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        Boolean result = false;
        Card definingCard = null;
        for (int i = 0; i < Hand.HAND_SIZE; i++) {
            Integer handCount = hand.findCards(hand.getCardByIndex(i).getValue()).size();
            if(handCount==this.count)
            {
                if(null!=definingCard && definingCard.getValue()!= hand.getCardByIndex(i).getValue())
                {
                    return new HandRecognitionResult(false, definingCard);
                }
                definingCard = hand.getCardByIndex(i); 
                result = true;
            }
            else if(handCount>=this.count)return new HandRecognitionResult(false, definingCard);
            else if(handCount !=1)return new HandRecognitionResult(false, definingCard);
        }
        return new HandRecognitionResult(result, definingCard);
    }
}
