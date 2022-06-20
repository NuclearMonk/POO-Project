package src.java.poker.player.actions;

import src.java.poker.app.App;

public class SetBetAmountAction implements PlayerAction {
	private Integer amountToSet;
	private static final int MAX_BET = 5;
	private static final int MIN_BET = 1;

	/**
	 * 
	 * @param amountToSet 
	 */
	public SetBetAmountAction(Integer amountToSet) {
		this.amountToSet = amountToSet;
	}

	/**
	 * Apply the action which is setting the bet amount to amountToSet if it is
	 * between the MIN_BET and MAX_BET otherwise it will print illegal amount
	 * 
	 * @param app
	 */

	public void doAction(App app) {
		if (amountToSet < MIN_BET || amountToSet > MAX_BET) {
			if(app.getStream()!=null)
			{
				app.getStream().println("b: illegal amount");
			}
		} else {
			app.getPlayer().setCurrentBet(amountToSet);
			if(app.getStream()!=null)
			{
				String output = "The player is currently betting " + app.getPlayer().getCurrentBet();
				app.getStream().println(output);
			}
		}

	}

}
