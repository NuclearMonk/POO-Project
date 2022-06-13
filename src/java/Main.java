package src.java;

import src.java.poker.app.App;
import src.java.poker.app.factories.AppFactory;

/**
 * Main Class
 */
public class Main {
	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		final App app = AppFactory.createApp(args);
		if (null == app)
			return;
		app.run();
	}
}
