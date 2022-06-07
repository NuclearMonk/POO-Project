package src.java.poker.player.actions;

import src.java.poker.app.App;

public class CheckBalanceAction implements PlayerAction {

    public void doAction(App app) {
        if(app == null)
        {
            throw new NullPointerException("app can't be null");
        }
        System.out.println("player's credit is "+ app.getPlayer().getBalance());

    }

}
