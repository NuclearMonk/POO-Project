package src.java.poker.app.hand.recognition.countbased;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class FourAcesRecognizer extends RangedFourOfAKindRecognizer {

    public FourAcesRecognizer() {
        super(Card.ACE, Card.ACE);
    }

}
