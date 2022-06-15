package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.card.Card;

public class FourToStraight extends ToStraight {

    public FourToStraight() {
        super("4 TO A Straight", 0, 4);
    }
}
