package src.java.poker.app.hand.recognition.multiple;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;

public abstract class MultipleMatchRecognizer extends HandRecognizer {
    private final int lowCount;
    private final int highCount;


    protected MultipleMatchRecognizer(String handName, int rewardMultiplier, int lowCount, int highCount) {
        super(handName, rewardMultiplier);
        this.lowCount = lowCount;
        this.highCount = highCount;
    }


    @Override
    public HandRecognitionResult recognizeHand(Hand hand) {
        Boolean result = false;
        Card highCard = null;
        Card lowCard = null;
        for (int i = 0; i < Hand.HAND_SIZE; i++) {
            int handCount = hand.findCards(hand.getCardByIndex(i).getValue()).size();
            if (null != lowCard)// ww already have a low card
            {
                if (this.highCount == handCount) {
                    highCard = hand.getCardByIndex(i);
                }
            } else // we don't have a low card
            {
                if (this.lowCount == handCount) // and this card fits our low count
                {
                    lowCard = hand.getCardByIndex(i);
                } else if (this.highCount == handCount) // and the card fits our high count
                {
                    highCard = hand.getCardByIndex(i);
                }
            }
        }
        result = highCard != null && lowCard != null && highCard.getValue() != lowCard.getValue();
        if (lowCount == highCount && result) {
            if (highCard.compareTo(lowCard) > 0) {
                return new HandRecognitionResult(result, highCard);
            } else {
                return new HandRecognitionResult(result, lowCard);
            }
        }
        return new HandRecognitionResult(result, highCard);
    }

}
