package src.java.poker.app.hand.recognition.oneOrTwoCards;

import src.java.poker.card.Card;
/**
 * 
 * Same suit Ten and King recognizer 
 *
 */
public class KTSuited extends SpecificSuited {
	/**
	 * Public Constructor of the class that set handName to "Suited King and Ten"
	 * and the highCard to Card.JACK and lowCard to Card.Ten
	 */
	public KTSuited() {
		super("Suited King and Ten", Card.KING, Card.TEN);
	}
}
