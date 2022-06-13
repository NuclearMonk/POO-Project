package src.java.poker.app.factories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import src.java.poker.app.App;
import src.java.poker.deck.DebugDeck;
import src.java.poker.player.DebugPlayer;

public class AppFactory {
    private AppFactory() {
    }

    public static App createApp(String[]args)
    {
        System.out.println(Arrays.toString(args));//TODO remove this debug print
        if(args.length != 3)
        {
            return null;
        }
        if(args[0].equals("-d"))
        {
            File playerFile = new File(args[1]);
            File cardFile = new File(args[2]);
            try {
                return new App(new DebugPlayer(playerFile,10000), new DebugDeck(cardFile));
            } catch (FileNotFoundException e) {
                return null;
            }
        }
        //TODO add simulation player
        return null;
    }
}
