package src.java.poker.player.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;

public class HoldCardsAction implements PlayerAction {
    private List<Integer> indexes;

    public HoldCardsAction(List<Integer> indexes) {
        Collections.sort(indexes);
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
        app.afterRoundProcessing();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((indexes == null) ? 0 : indexes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HoldCardsAction other = (HoldCardsAction) obj;
        if (indexes == null) {
            if (other.indexes != null)
                return false;
        } else if (!indexes.equals(other.indexes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hold" + indexes;
    }
}
