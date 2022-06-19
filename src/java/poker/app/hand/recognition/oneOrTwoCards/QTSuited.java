package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

public class QTSuited extends SpecificSuited {
	/**
	 * Public Constructor of the class that set handName to "QTSuited"
	 * and the highCard to Card.QUEEN and lowCard to Card.TEN
	 */
	public QTSuited() {
		super("QTSuited", Card.QUEEN, Card.TEN);
	}

}
