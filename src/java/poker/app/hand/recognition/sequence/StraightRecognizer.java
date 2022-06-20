package src.java.poker.app.hand.recognition.sequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
/**
 * 
 * Straight Recognizer
 *
 */
public class StraightRecognizer extends HandRecognizer {
	/**
	 * public constructor that set handName to "STRAIGHT" and rewardMultiplier
	 * to 5
	 */
	public StraightRecognizer() {
		super("STRAIGHT", 5);
	}
/**
 * 
 * @param handName
 * @param rewardMultiplier
 */
	protected StraightRecognizer(String handName, int rewardMultiplier) {
		super(handName, rewardMultiplier);
	}
	/**
	 * recognize if the hand has "STRAIGHT"
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		List<Card> handAsList = hand.cardsAsList();
		Collections.sort(handAsList);
		Card firstCard = handAsList.get(0);
		if (handAsList.get(handAsList.size() - 1).getValue() == Card.ACE) { // we can either have a TJQKA or an A2345
			if (firstCard.getValue() == 2 || firstCard.getValue() == 10) {
				int lastValue = firstCard.getValue();
				for (int i = 1; i < handAsList.size() - 1; i++) {
					if (handAsList.get(i).getValue() - lastValue != 1) // if they differ in less or more than one to the
																		// last card
					{
						return new HandRecognitionResult(false, null);
					}
					lastValue = handAsList.get(i).getValue();
				}
				if (firstCard.getValue() == 2) {
					return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 2));
				}
				if (firstCard.getValue() == 10) {
					return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 1));
				}
				return new HandRecognitionResult(false, null);
			}
		} else if (firstCard.getValue() >= Card.JACK)// THERE ARE NO STRAIGHTS THAT START WITH JACK AS THE LOWEST CARD

		{
			return new HandRecognitionResult(false, null);
		} else {
			int lastValue = firstCard.getValue();
			for (int i = 1; i < handAsList.size(); i++) {
				if (handAsList.get(i).getValue() - lastValue != 1) // if they differ in less or more than one to the
																	// last
																	// card
				{
					return new HandRecognitionResult(false, null);
				}
				lastValue = handAsList.get(i).getValue();
			}
			return new HandRecognitionResult(true, handAsList.get(handAsList.size() - 1));
		}
		return new HandRecognitionResult(false, null);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}
}
