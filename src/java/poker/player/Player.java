package src.java.poker.player;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;

public abstract class Player {

    protected int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    protected int currentBet = 5;

    protected Player(int balance) {
        this.balance = balance;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public void chargeBetAmount(int amount) {
        this.balance -= amount;
    }

    public void creditReward(int amount) {
        this.balance += amount;
    }

    public abstract PlayerAction getAction(Hand hand);
}
