package src.java.poker.player.actions;

import src.java.poker.app.App;

public class SetBetAmountAction implements PlayerAction {
    private Integer amountToSet;
    private static int MAX_BET = 5;
    private static int MIN_BET = 1;

    public SetBetAmountAction(Integer amountToSet) {
        this.amountToSet = amountToSet;
    }

    public void doAction(App app) {
        if (amountToSet < MIN_BET || amountToSet > MAX_BET) {
            System.out.println("b: illegal amount");
        } else {
            app.getPlayer().setCurrentBet(amountToSet);
            String output = "The player is currently betting " + app.getPlayer().getCurrentBet();
            System.out.println(output);
        }

    }

}
