package src.java.poker.player;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.PlayerAction;

public class SimulationPlayer extends Player {

    private Boolean shouldDeal = true;
    private Brain brain = new Brain();

    public SimulationPlayer(int balance) {
        super(balance);
    }

    @Override
    public PlayerAction getAction(Hand hand) {
        if (shouldDeal) {
            return new DealAction();
        } else {
            return brain.getAction(hand);
        }
    }

}
