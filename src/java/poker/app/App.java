package src.java.poker.app;

import java.util.ArrayList;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.Four5KRecognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.count.JacksOrBetterRecognizer;
import src.java.poker.app.hand.recognition.count.ThreeOfARecognizer;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.deck.Deck;
import src.java.poker.player.Player;
import src.java.poker.player.actions.PlayerAction;
/**
 */
public class App {
    private final Player player;
    /**
     * 
     * @return player which has been defined inside the App
     */

    public Player getPlayer() {
        return player;
    }

    private final Deck deck;
/**
 * 
 * @return deck which has been defined inside the App
 */
    public Deck getDeck() {
        return deck;
    }

    private Hand hand;
/**
 * 
 * @param Hand the current player is playing
 */
    public void setHand(Hand hand) {
        this.hand = hand;
    }
/**
 *  
 * @return Hand 
 */
    public Hand getHand() {
        return hand;
    }

    private int ongoingBetAmount = 0;
/**
 * 
 * @return ongoing Bet Amount that the player is betting
 */
    public int getOngoingBetAmount() {
        return ongoingBetAmount;
    }
    /**
     * 
     * @param ongoing Bet Amount to be set as the current bet
     */

    public void setOngoingBetAmount(int ongoingBetAmount) {
        this.ongoingBetAmount = ongoingBetAmount;
    }

    private ArrayList<HandRecognizer> recognizers;
/**
 * An constructor for the App
 * @param player
 * @param deck
 */
    public App(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
        recognizers = new ArrayList<>();
        recognizers.add(new RoyalFlushRecognizer());
        recognizers.add(new StraightFlushRecognizer());
        recognizers.add(new FourAcesRecognizer());
        recognizers.add(new Four24Recognizer());
        recognizers.add(new Four5KRecognizer());
        recognizers.add(new FullHouseRecognizer());
        recognizers.add(new FlushRecognizer());
        recognizers.add(new StraightRecognizer());
        recognizers.add(new ThreeOfARecognizer());
        recognizers.add(new TwoPairRecognizer());
        recognizers.add(new JacksOrBetterRecognizer());
    }
/**
 *  to start playing
 */
    public void run() {
        PlayerAction action;
        do {
            action = this.player.getAction(this.hand);
            if (null != action) {
                action.doAction(this);
            }
        } while (null != action);
    }
/**
 * Check the hand of the player and determine if he wins or not, change his balance and call the deck.shuffle()
 */
    public void afterRoundProcessing() {
        for (HandRecognizer handRecognizer : recognizers) {
            if (handRecognizer.recognizeHand(this.hand).isResult()) {
                this.player.creditReward(handRecognizer.getRewardMultiplier() * ongoingBetAmount);
                System.out.println("Player Wins with " + handRecognizer.getHandName() + " and his credit is: "
                        + this.player.getBalance());
                this.deck.shuffle();
                return;
            }
        }
        this.deck.shuffle();
        System.out.println("Player Loses and his credit is: " + this.player.getBalance());
    }
}