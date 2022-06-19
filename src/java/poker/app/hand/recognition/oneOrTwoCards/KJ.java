package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;

public class KJ extends SpecificUnsuited {
	/**
	 * Public Constructor of the class that set handName to "KJ unsuited" and
	 * and the lowCard to Card.JACK and highCard to Card.KING
	 */
	public KJ() {
		super("KJ unsuited", Card.JACK, Card.KING);
	}

}
