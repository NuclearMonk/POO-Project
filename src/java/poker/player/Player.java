package src.java.poker.player;

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

    public Player(int balance) {
        this.balance = balance;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public void chargeBetAmount()
    {
        this.balance -= currentBet;
    }

    public void creditReward(int value)
    {
        this.balance+=value;
    }

    public abstract PlayerAction getAction();
}
