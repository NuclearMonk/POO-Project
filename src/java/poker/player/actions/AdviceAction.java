package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.player.Brain;

/**
 * Action that prints Advice for the player to follow
 */
public class AdviceAction implements PlayerAction {
	private static final Brain BRAIN = new Brain();

	/**
	 * Based on the hand it will print what the player should do according to the
	 * strategy which defines the Simulation player
	 * @param app the app that the action will be applied to
	 */
	@Override
	public void doAction(App app) {
		PlayerAction action = BRAIN.getAction(app.getHand());
		if(app.getStream()!=null)
		{

			app.getStream().println("player should " + action);
		}
	}

}
