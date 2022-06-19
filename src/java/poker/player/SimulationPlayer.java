package src.java.poker.player;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.PlayerAction;
import src.java.poker.player.actions.StatsAction;

public class SimulationPlayer extends Player {

    private Boolean shouldDeal = true;
    private Brain brain = new Brain();
    private int numberOfDeals;

    public SimulationPlayer(int balance,int betAmount, int numberOfDeals) {
        super(balance);
        this.currentBet = betAmount;
        this.numberOfDeals = numberOfDeals;
    }

    @Override
    public PlayerAction getAction(Hand hand) {
        if(numberOfDeals <0)
        {
            System.out.println("WTF");
            return null;
        }
        else if(numberOfDeals ==0)
        {
            numberOfDeals--;
            return new StatsAction();
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
