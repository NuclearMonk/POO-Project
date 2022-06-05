package src.java.poker.player.actions;


import src.java.poker.app.App;
import src.java.poker.player.Hand;

public class DealAction implements PlayerAction {

    public void doAction(App app) {
        app.setHand(new Hand(app.getDeck()));
        System.out.println("Player's Hand: " + app.getHand());
    }

}
