package src.java.poker.player.actions;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;

public class HoldCardsAction implements PlayerAction {
    private List<Integer> indexes;

    public HoldCardsAction(List<Integer> indexes) {
        this.indexes = indexes;
    }

    @Override
    public void doAction(App app) {
        if(app == null)
        {
            throw new NullPointerException("app can't be null");
        }
        ArrayList<Integer> swapIndexes = new ArrayList<>();
        for (int i = 1; i <= Hand.HAND_SIZE; i++) {
            if (!indexes.contains(i)) {
                swapIndexes.add(i);
            }
        }
        app.getHand().replaceCards(app.getDeck(), swapIndexes);
        System.out.println("player's Hand " + app.getHand());
        app.checkHandState();
    }
}
