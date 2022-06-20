package src.java.poker.player.actions;

import src.java.poker.app.App;
/**
 * Action to check the player's balance
 */
public class CheckBalanceAction implements PlayerAction {
	/**
	 * Check the balance of the player 
	 * @param app the app
	 */
	public void doAction(App app) {
		if (app == null) {
			throw new NullPointerException("app can't be null");
		}
		System.out.println("player's credit is " + app.getPlayer().getBalance());
	}

}
