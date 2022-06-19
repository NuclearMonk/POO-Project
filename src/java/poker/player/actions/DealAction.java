package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;

public class DealAction implements PlayerAction {
	/**
	 * Deals cards from the deck to the hand
	 * 
	 * @param App
	 */
	public void doAction(App app) {
		if (app == null) {
			throw new NullPointerException("app can't be null");
		}
		app.setOngoingBetAmount(app.getPlayer().getCurrentBet());
		app.getPlayer().chargeBetAmount(app.getOngoingBetAmount());
		app.setHand(new Hand(app.getDeck()));
		System.out.println("player's hand " + app.getHand());
	}

}
