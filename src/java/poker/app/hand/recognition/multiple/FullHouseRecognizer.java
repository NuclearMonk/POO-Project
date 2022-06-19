package src.java.poker.app.hand.recognition.multiple;

import java.util.Arrays;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

/**
 * 
 * FullHouse Recognizer
 *
 */
public class FullHouseRecognizer extends MultipleMatchRecognizer {
	/**
	 * public Constructor set handName to "FULL HOUSE", rewardMultiplyer to 10,
	 * highCount to 3 and lowCount 2
	 */
	public FullHouseRecognizer() {
		super("FULL HOUSE", 10, 2, 3);
	}

	/**
	 * @param hand to give the action according to
	 * @return PlayerAction to hold cards that matches the class criterion
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}

}
