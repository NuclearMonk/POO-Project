package src.java.poker.app.hand.analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.RangedFourOfAKindRecognizer;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class StraightFlush4OfKindRoyalFlush extends HandAnalyzer implements HandAction {

	public StraightFlush4OfKindRoyalFlush() {
		super("Straight flush, four of a kind, royal flush");
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {

		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4);
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		HandRecognitionResult result = new StraightFlushRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		result = new RangedFourOfAKindRecognizer("Four of Kind", 0, Card.ACE, Card.KING).recognizeHand(hand);
		if (result.isResult())
			return result;
		result = new RoyalFlushRecognizer().recognizeHand(hand);
		if (result.isResult())
			return result;
		return new HandRecognitionResult(false, null);
	}

}
