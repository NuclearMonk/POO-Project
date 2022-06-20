package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;

/**
 * Action for dealing the player a new hand of 5 cards
 */
public class DealAction implements PlayerAction {

    public void doAction(App app) {
        if (app == null) {
            throw new NullPointerException("app can't be null");
        }
        app.setOngoingBetAmount(app.getPlayer().getCurrentBet());
        app.getPlayer().chargeBetAmount(app.getOngoingBetAmount());
        app.setHand(new Hand(app.getDeck()));
        app.setHandCount(app.getHandCount()+1);
        if(app.getStream()!=null)
        {
            app.getStream().println("player's hand " + app.getHand());
        }
    }

}
