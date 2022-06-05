package src.java;


import java.io.File;
import java.io.FileNotFoundException;

import src.java.poker.app.App;
import src.java.poker.deck.DebugDeck;
import src.java.poker.player.DebugPlayer;
/**
 * Main Class
 */
public class Main {
	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		File cardFile = new File("Resources\\ExampleFiles\\card-file.txt");
		App app;
		try {
			app = new App(new DebugPlayer(), new DebugDeck(cardFile));
			app.run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
