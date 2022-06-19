package src.java.poker.app.hand.recognition.missingcards.flush;

import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class ToFlush extends HandRecognizer {

	protected int countToFlush;

	/**
	 * Public Constructor
	 * 
	 * @param handName
	 * @param rewardMultiplier
	 * @param toFlush          which is the number of cards with the same suite
	 */
	protected ToFlush(String handName, int rewardMultiplier, int toFlush) {
		super(handName, rewardMultiplier);
		this.countToFlush = toFlush;
	}
	/**
	 * @param Hand to give the action according to 
	 * @return PlayerAction to hold cards that matches the class criterion
	 */

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where there is a number of cards with the same suit and it equals
	 * to countToFlush
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		Boolean result = false;
		Card definingCard = null;
		for (Card C : hand.cardsAsList()) {

			Integer handCount = hand.findCards(C.getSuit()).size();

			if (handCount == this.countToFlush) {
				result = true;
				List<Card> handList = hand.cardsAsList();
				Collections.sort(handList); // sort the hand from lowest tom highest
				Collections.reverse(handList); // reverse the hant to get highest to lowest
				if (handList.get(0).getSuit().equals(C.getSuit()))
					definingCard = handList.get(0);
				else if (handList.get(1).getSuit().equals(C.getSuit()))
					definingCard = handList.get(1);
				else
					definingCard = handList.get(2);
				break;
			}
		}
		return new HandRecognitionResult(result, definingCard);

	}

}
