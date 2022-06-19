package src.java.poker.player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.AdviceAction;
import src.java.poker.player.actions.CheckBalanceAction;
import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
import src.java.poker.player.actions.SetBetAmountAction;
import src.java.poker.player.actions.StatsAction;

public class DebugPlayer extends Player {
    private Scanner scanner;
/**
 * 
 * @param inputFile with the instructions
 * @param balance to start the game with
 */
    public DebugPlayer(File inputFile, int balance) {
        super(balance);
        try {
            this.scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("player input file does not exist");
        }
    }
/**
 * 
 * @param Hand to give the action to
 * @return PlayerAction 
 */
    @Override
    public PlayerAction getAction(Hand hand) {

        if (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("b")) {
                if (scanner.hasNextInt()) {
                    return new SetBetAmountAction(scanner.nextInt());
                } else {
                    return new SetBetAmountAction(currentBet);

                }
            } else if (next.equals("d")) {
                return new DealAction();
            } else if (next.equals("h")) {
                ArrayList<Integer> indexes = new ArrayList<>(5);
                while (scanner.hasNextInt()) {
                    indexes.add(scanner.nextInt());
                }
                return new HoldCardsAction(indexes);
            } else if (next.equals("$")) {
                return new CheckBalanceAction();
            } else if (next.equals("a")) {
                return new AdviceAction();
            } else if (next.equals("s")) {
                return new StatsAction();
            } else {
                System.out.println("Unknown Command");
            }
        }
        return null;
    }

}
