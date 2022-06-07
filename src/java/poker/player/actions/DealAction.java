package src.java.poker.player.actions;


import src.java.poker.app.App;
import src.java.poker.player.Hand;

public class DealAction implements PlayerAction {

    public void doAction(App app) {
        if(app == null)
        {
            throw new NullPointerException("app can't be null");
        }
        app.setHand(new Hand(app.getDeck()));
        System.out.println("player's hand " + app.getHand());
    }

}
