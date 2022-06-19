package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

/**
 * 
 * Queen and Jack recognizer regardless of the suit
 *
 */
public class QJUnsuited extends SpecificUnsuited {
	/**
	 * Public Constructor of the class that set handName to "QJ unsuited" and the
	 * highCard to Card.QUEEN and lowCard to Card.JACK
	 */
	public QJUnsuited() {

		super("QJ unsuited", Card.JACK, Card.QUEEN);
	}

}
