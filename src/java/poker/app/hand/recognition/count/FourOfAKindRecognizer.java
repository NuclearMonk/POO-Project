package src.java.poker.app.hand.recognition.count;

public abstract class FourOfAKindRecognizer extends OfAKindRecognizer{

    protected FourOfAKindRecognizer(String handName, int rewardMultiplier, int count) {
        super(handName, rewardMultiplier, 4);
    }
    
}
