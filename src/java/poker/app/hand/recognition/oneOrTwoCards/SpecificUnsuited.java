package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class SpecificUnsuited extends HandRecognizer {
	final int highCard;
	final int lowCard;

	/**
	 * protected constructor
	 * 
	 * @param handName
	 * @param lowCard
	 * @param highCard
	 */
	protected SpecificUnsuited(String handName, int lowCard, int highCard) {
		super(handName, 0);
		this.lowCard = lowCard;
		this.highCard = highCard;
	}

	/**
	 * 
	 * @return high Card
	 */
	public int getHighCard() {
		return highCard;
	}

	/**
	 * 
	 * @return low Card
	 */
	public int getLowCard() {
		return lowCard;
	}

	/**
	 * Recognizing Where there are specific cards defined by highCard and lowCard
	 * attributes in the hand
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		boolean lowCardFound = false;
		boolean highCardFound = false;
		Card definingCard = null;
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() == this.highCard) {
				highCardFound = true;
			} else if (C.getValue() == this.lowCard) {
				lowCardFound = true;
				definingCard = C;

			}
		}
		if (lowCardFound && highCardFound)
			return new HandRecognitionResult(true, definingCard);
		else
			return new HandRecognitionResult(false, null);

	}

	/**
	 * @param Hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = new ArrayList<>();
		indexes.addAll(hand.getCardIndex(lowCard));
		indexes.addAll(hand.getCardIndex(highCard));
		return new HoldCardsAction(indexes);

	}

}
