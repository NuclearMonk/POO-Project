package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

/**
 * Specific same suit two cards recognizer
 *
 */
public abstract class SpecificSuited extends HandRecognizer {
	final int lowCard;
	final int highCard;

	/**
	 * protected constructor
	 * 
	 * @param handName which will be given to the hand
	 * @param lowCard  specify the low value to look for
	 * @param highCard specify the high value to look for
	 */
	protected SpecificSuited(String handName, int highCard, int lowCard) {
		super(handName, 0);
		this.highCard = highCard;
		this.lowCard = lowCard;
	}

	/**
	 * getter of lowCard
	 * 
	 * @return low Card
	 */
	public int getLowCard() {
		return lowCard;
	}

	/**
	 * getter of high Card
	 * 
	 * @return high Card
	 */
	public int getHighCard() {
		return highCard;
	}

	/**
	 * 
	 * 
	 * @param hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		Suit S = this.recognizeHand(hand).getDefiningCard().getSuit();
		List<Integer> indexes = hand.getCardIndex(getLowCard(), S);
		indexes.addAll(hand.getCardIndex(getHighCard(), S));
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where there are specific cards defined by highCard and lowCard
	 * attributes and that they have the same suite
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		ArrayList<Suit> highCardSuit = new ArrayList<Suit>();
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == this.lowCard || C.getValue() == this.highCard)
				highCardSuit.add(C.getSuit());
		}
		for (Suit s : Suit.values()) {
			if (Collections.frequency(highCardSuit, s) == 2) {
				Card definingCard = new Card(Card.QUEEN, s);
				return new HandRecognitionResult(true, definingCard);
			}
		}
		return new HandRecognitionResult(false, null);

	}

}
