package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.player.Brain;

public class AdviceAction implements PlayerAction{

    private static final  Brain BRAIN = new Brain();

    @Override
    public void doAction(App app) {
        PlayerAction action = BRAIN.getAction(app.getHand());

        System.out.println("player should "+ action);
    }
    
}
