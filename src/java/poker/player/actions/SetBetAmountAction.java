package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.player.Player;

public class SetBetAmountAction implements PlayerAction {
    private Integer amountToSet;


    public SetBetAmountAction(Integer amountToSet) {
        this.amountToSet = amountToSet;
    }


    public void doAction(App app) {
        app.getPlayer().setCurrentBet(amountToSet);
        String output = "The player is currently betting " + app.getPlayer().getCurrentBet();
        System.out.println(output);

    }

}
