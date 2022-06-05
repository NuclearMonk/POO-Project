package src.java.poker.player;

import java.util.ArrayList;

import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
import src.java.poker.player.actions.SetBetAmountAction;

public class DebugPlayer extends Player {

    private int actionCount = 0;

    @Override
    public PlayerAction getAction() {
        actionCount++;
        switch (actionCount) {
            case 1:
                return new SetBetAmountAction(5);
            case 2:
                return new DealAction();
            case 3:
                ArrayList<Integer> holdIndexes = new ArrayList<>();
                holdIndexes.add(1);
                holdIndexes.add(3);
                return new HoldCardsAction(holdIndexes);
            default:
                return null;
        }

    }

}
