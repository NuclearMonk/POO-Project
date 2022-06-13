package src.java.poker.app.hand.analyzer;

import java.util.Arrays;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class StraightOrFlushFullHouse extends HandRecognizer implements HandAction {

	public StraightOrFlushFullHouse() {
		super("Straight, flush, full house", 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = new StraightRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		result = new FlushRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		result = new FullHouseRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		return new HandRecognitionResult(false, null);
	}

}
