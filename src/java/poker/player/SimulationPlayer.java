package src.java.poker.player;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.analyzer.ThreeAces;
import src.java.poker.app.hand.analyzer.ThreeOfAKindNotAce;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.Four5KRecognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.count.FourOfAKindRecognizer;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.player.actions.PlayerAction;

public class SimulationPlayer extends Player{

    private List<HandRecognizer> recognizers;

    public SimulationPlayer(int balance) {
        super(balance);
        this.recognizers = new ArrayList<>();
        recognizers.add(new StraightFlushRecognizer());
        recognizers.add(new FourAcesRecognizer());
        recognizers.add(new Four24Recognizer());
        recognizers.add(new Four5KRecognizer());
        recognizers.add(new StraightFlushRecognizer());
        recognizers.add(new ThreeAces());
        recognizers.add(new StraightRecognizer());
        recognizers.add(new FlushRecognizer());
        recognizers.add(new FullHouseRecognizer());
        recognizers.add(new ThreeOfAKindNotAce());
        

    }

    @Override
    public PlayerAction getAction(Hand hand) {
        for (HandRecognizer handRecognizer : this.recognizers) {
            if(handRecognizer.recognizeHand(hand).isResult())
            {
                return handRecognizer.getAdviceAction(hand);
            }
        }
        return null;
    }
    
}
