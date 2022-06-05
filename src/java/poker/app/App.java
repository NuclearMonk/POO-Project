package src.java.poker.app;

import src.java.poker.deck.Deck;
import src.java.poker.player.DebugPlayer;
import src.java.poker.player.Hand;
import src.java.poker.player.Player;
import src.java.poker.player.actions.PlayerAction;

public class App {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    private Deck deck;

    private Hand hand;

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public App(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
    }

    public void run() {
        player = new DebugPlayer();
        for (int i = 0; i < 3; i++) {
            PlayerAction action = player.getAction();
            /* TODO add checks */
            action.doAction(this);
        }

        /* TODO add after action game related checks */
    }
}
