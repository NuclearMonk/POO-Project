package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

/**
 * 
 * Same suit Jack and ten recognizer
 *
 */
public class JTSuited extends SpecificSuited {
	/**
	 * Public Constructor of the class that set handName to "Suited Ten and Jack"
	 * and and the highCard to Card.JACK and lowCard to Card.TEN
	 */
	public JTSuited() {
		super("Suited Ten and Jack", Card.JACK, Card.TEN);

	}

}
