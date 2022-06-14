package src.java.poker.app.hand.recognition.multiple;

import java.util.Arrays;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class FullHouseRecognizer extends MultipleMatchRecognizer {

	public FullHouseRecognizer() {
		super("FULL HOUSE", 10, 2, 3);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}

}
