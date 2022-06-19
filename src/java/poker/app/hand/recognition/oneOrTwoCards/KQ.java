package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

public class KQ extends SpecificUnsuited {
	/**
	 * Public Constructor of the class that set handName to "KQ unsuited" and
	 * and the lowCard to Card.QUEEN and highCard to Card.KING
	 */
	public KQ() {
		super("KQ unsuited", Card.QUEEN, Card.KING);
	}

}
