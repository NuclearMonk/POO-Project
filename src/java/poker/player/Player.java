package src.java.poker.player;

import src.java.poker.app.App;
import src.java.poker.player.actions.PlayerAction;

public abstract class Player {

    protected int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    protected int currentBet;

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }


    public abstract PlayerAction getAction();
}
