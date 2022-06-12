package src.java.poker.app.hand.recognition.count;
import src.java.poker.card.Card;

public class FourAcesRecognizer extends RangedFourOfAKindRecognizer {

    public FourAcesRecognizer() {
        super("FOUR ACES", 160, Card.ACE, Card.ACE);
    }


}
