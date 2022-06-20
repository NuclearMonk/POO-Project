package src.java.poker.player;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;

/**
 * Abstract player
 * 
 *
 */
public abstract class Player {

	protected int balance;

	/**
	 * 
	 * @return balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * 
	 * @param balance the players initial balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	protected int currentBet = 5;

	/**
	 * protected constructor
	 * 
	 * @param balance the player's initial balance
	 */
	protected Player(int balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @return current Bet
	 */

	public int getCurrentBet() {
		return currentBet;
	}

	/**
	 * 
	 * @param currentBet the current betting amount
	 */
	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}

	/**
	 * @param amount to take from balance
	 */
	public void chargeBetAmount(int amount) {
		this.balance -= amount;
	}

	/**
	 * 
	 * @param amount to add to the balance
	 */
	public void creditReward(int amount) {
		this.balance += amount;
	}

	/**
	 * Abstract Method
	 * 
	 * @param hand the hand state the player player will be reacting to
	 * @return PlayerAction
	 */
	public abstract PlayerAction getAction(Hand hand);
}
