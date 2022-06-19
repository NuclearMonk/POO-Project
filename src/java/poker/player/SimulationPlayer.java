package src.java.poker.player;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.PlayerAction;

public class SimulationPlayer extends Player {

    private Boolean shouldDeal = true;
    private Brain brain = new Brain();
    private int numberOfDeals;
/**
 * public constructor for Simulation player
 * @param balance
 * @param betAmount
 * @param numberOfDeals
 */
    public SimulationPlayer(int balance,int betAmount, int numberOfDeals) {
        super(balance);
        this.currentBet = betAmount;
        this.numberOfDeals = numberOfDeals;
    }
    /**
     * @param hand to do the action according to 
     * @return PlayerAction
     */

    @Override
    public PlayerAction getAction(Hand hand) {
        if(numberOfDeals ==0)
        {
            return null;
        }
        if (shouldDeal) {
            numberOfDeals--;
            shouldDeal = !shouldDeal;
            return new DealAction();
        } else {
            shouldDeal = !shouldDeal;
            return brain.getAction(hand);
        }
    }

}
