package src.java.poker.player;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.HighPair;
import src.java.poker.app.hand.recognition.ThreeAces;
import src.java.poker.app.hand.recognition.ThreeOfAKindNotAce;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.Four5KRecognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.missingcards.flush.FourToFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToRoyalFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToStraightFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToRoyalFlush;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.player.actions.PlayerAction;

public class SimulationPlayer extends Player {

    private List<HandRecognizer> recognizers;

    public SimulationPlayer(int balance) {
        super(balance);
        this.recognizers = new ArrayList<>();
        /* 1 */
        recognizers.add(new RoyalFlushRecognizer());
        recognizers.add(new FourAcesRecognizer());
        recognizers.add(new Four24Recognizer());
        recognizers.add(new Four5KRecognizer());
        recognizers.add(new StraightFlushRecognizer());
        /* 2 */
        recognizers.add(new FourToRoyalFlush());
        /* 3 */
        recognizers.add(new ThreeAces());
        /* 4 */
        recognizers.add(new StraightRecognizer());
        recognizers.add(new FlushRecognizer());
        recognizers.add(new FullHouseRecognizer());
        /* 5 */
        recognizers.add(new ThreeOfAKindNotAce());
        /* 6 */
        recognizers.add(new FourToStraightFlush());
        /* 7 */
        recognizers.add(new TwoPairRecognizer());
        /* 8 */
        recognizers.add(new HighPair());
        /* 9 */
        recognizers.add(new FourToFlush());
        /* 10 */
        recognizers.add(new ThreeToRoyalFlush());
    }

    @Override
    public PlayerAction getAction(Hand hand) {
        for (HandRecognizer handRecognizer : this.recognizers) {
            if (handRecognizer.recognizeHand(hand).isResult()) {
                return handRecognizer.getAdviceAction(hand);
            }
        }
        return null;
    }

}
