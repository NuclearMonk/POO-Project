package src.java.poker.app.hand.recognition.count;

public class TwoOfAKindRecognizer extends OfAKindRecognizer{

    protected TwoOfAKindRecognizer(String handName, int rewardMultiplier) {
        super(handName, rewardMultiplier, 2);
    }

}
