package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;
/**
 * 
 * Same suit Jack and Queen recognizer
 *
 */
public class QJSuited extends SpecificSuited {
	/**
	 * Public Constructor of the class that set handName to "Suited Queen and Jack"
	 * and the highCard to Card.QUEEN and lowCard to Card.JACK
	 */
	public QJSuited() {
		super("Suited Queen and Jack", Card.QUEEN, Card.JACK);
	}

}
