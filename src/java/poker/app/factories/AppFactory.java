package src.java.poker.app.factories;

import java.io.File;
import java.io.FileNotFoundException;

import src.java.poker.app.App;
import src.java.poker.deck.DebugDeck;
import src.java.poker.deck.StandardDeck;
import src.java.poker.player.DebugPlayer;
import src.java.poker.player.SimulationPlayer;
/**
 * App factory to handle command line
 *
 */
public class AppFactory {
    private AppFactory() {
    }
/**
 * 
 * @param args the command
 * @return App
 */
    public static App createApp(String[] args) {
        if (args.length != 4) {
            return null;
        }
        if (args[0].equals("-d")) {
            File playerFile = new File(args[2]);
            File cardFile = new File(args[3]);
            try {
                return new App(new DebugPlayer(playerFile, Integer.parseInt(args[1])), new DebugDeck(cardFile),System.out);
            } catch (FileNotFoundException e) {
                return null;
            }
        } else if (args[0].equals("-s")) {
            return new App(new SimulationPlayer(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
                    Integer.parseInt(args[3])), new StandardDeck(),null);

        }
        return null;
    }
}
