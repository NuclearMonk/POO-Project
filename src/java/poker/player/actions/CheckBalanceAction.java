package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.player.Player;

public class CheckBalanceAction implements PlayerAction {

    public void doAction(App app) {
        System.out.println("player's credit is "+ app.getPlayer().getBalance());

    }

}
