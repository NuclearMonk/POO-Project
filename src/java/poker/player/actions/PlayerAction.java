package src.java.poker.player.actions;

import src.java.poker.app.App;

public interface PlayerAction {
    /**
     * Interface for doing an action
     * @param app the app that the action will be applied to
     */
    public void doAction(App app);
}
