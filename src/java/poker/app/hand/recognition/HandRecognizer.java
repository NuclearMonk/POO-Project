package src.java.poker.app.hand.recognition;

import src.java.poker.app.hand.Hand;

public abstract class HandRecognizer {
    protected static int priority;
    public abstract HandRecognitionResult recognizeHand(Hand hand);
}
