package src.java.poker.app.hand.recognition.missingcards.straight;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
/**
 * 
 * abstract to Straight recognizer
 *
 */
public abstract class ToStraight extends HandRecognizer {
	protected final int toAStraightCount;

	/**
	 * Protected constructor
	 * 
	 * @param toAStraightCount the number of members of the straight that we have
	 */
	protected ToStraight(int toAStraightCount) {
		super("TO A STRAIGHT", 0);
		this.toAStraightCount = toAStraightCount;
	}

	/**
	 * Recognize if the hand has a number of Straight cards equal to
	 * toAStraightCount
	 * 
	 * @param hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		List<Integer> values = getStraightMembers(hand);
		if (values.size() >= toAStraightCount) {
			return new HandRecognitionResult(true, hand.findCards(values.get(0)).get(0));
		}
		return new HandRecognitionResult(false, null);
	}

	/**
	 * 
	 * @param hand to be checked
	 * @return List<Integer> of the cards' values that make the straight
	 */
	protected static List<Integer> getStraightMembers(Hand hand) {
		int highestToStraightCount = 0;
		ArrayList<Integer> valuesWeHave = new ArrayList<>();
		for (int cardValue = Card.ACE; cardValue <= Card.TEN; cardValue++) {
			int toStraightCount = 0;
			ArrayList<Integer> runningValues = new ArrayList<>();
			if (cardValue != Card.TEN) {
				for (int straightValueOffset = 0; straightValueOffset < 5; straightValueOffset++) {
					if (!hand.findCards(cardValue + straightValueOffset).isEmpty())// we found a gap
					{
						toStraightCount++;
						runningValues.add(cardValue + straightValueOffset);
					}
				}

			} else { /* Special case that checks for cards missing to a TJQKA straight */
				for (int straightValueOffset = 0; straightValueOffset < 4; straightValueOffset++) {
					if (!hand.findCards(cardValue + straightValueOffset).isEmpty())// we found a gap
					{
						toStraightCount++;
						runningValues.add(cardValue + straightValueOffset);
					}
				}
				if (!hand.findCards(Card.ACE).isEmpty())// we found a gap
				{
					toStraightCount++;
					runningValues.add(Card.ACE);
				}
			}
			if (toStraightCount >= highestToStraightCount) {
				valuesWeHave = runningValues;
				highestToStraightCount = toStraightCount;
			}
		}
		return valuesWeHave;
	}

	/**
	 * @param hand to give the action according to
	 * @return PlayerAction to hold cards that matches the class criterion
	 */

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> values = getStraightMembers(hand);
		ArrayList<Integer> indexes = new ArrayList<>();
		for (Integer value : values) {
			indexes.add(hand.getCardIndex(value).get(0));
		}
		return new HoldCardsAction(indexes);
	}

}
