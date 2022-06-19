package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.player.Brain;

public class AdviceAction implements PlayerAction {

	private static final Brain BRAIN = new Brain();

	/**
	 * Based on the hand it will print what the player should do according to the
	 * strategy which defines the Simulation player
	 * @param app
	 */
	@Override
	public void doAction(App app) {
		PlayerAction action = BRAIN.getAction(app.getHand());

		System.out.println("player should " + action);
	}

}
