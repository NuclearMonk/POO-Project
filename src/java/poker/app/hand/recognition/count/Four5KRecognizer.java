package src.java.poker.app.hand.recognition.count;

import src.java.poker.card.Card;

public class Four5KRecognizer extends RangedFourOfAKindRecognizer{

    public Four5KRecognizer() {
        super("FOUR 5-K", 50, 5, Card.KING);

    }
}
