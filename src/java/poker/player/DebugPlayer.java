package src.java.poker.player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import src.java.poker.player.actions.AdviceAction;
import src.java.poker.player.actions.CheckBalanceAction;
import src.java.poker.player.actions.DealAction;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
import src.java.poker.player.actions.SetBetAmountAction;

public class DebugPlayer extends Player {
    private Scanner scanner;

    public DebugPlayer(File inputFile) {
        try {
            this.scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public PlayerAction getAction() {

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
            } else {
                System.out.println("Unknown Command");
            }
        }
        return null;
    }

}
