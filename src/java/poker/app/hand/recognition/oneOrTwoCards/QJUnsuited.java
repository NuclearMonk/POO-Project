package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

public class QJUnsuited extends SpecificUnsuited {

	public QJUnsuited() {
		/**
		 * Public Constructor of the class that set handName to "QJ unsuited"
		 * and the highCard to Card.QUEEN and lowCard to Card.JACK
		 */
		super("QJ unsuited", Card.JACK, Card.QUEEN);
	}

}
