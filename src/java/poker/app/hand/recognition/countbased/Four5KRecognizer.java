package src.java.poker.app.hand.recognition.countbased;

import src.java.poker.card.Card;

public class Four5KRecognizer extends RangedFourOfAKindRecognizer{

    public Four5KRecognizer() {
        super(5, Card.KING);
    }
}
