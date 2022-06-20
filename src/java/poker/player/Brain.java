package src.java.poker.player;

import java.util.ArrayList;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.HighPair;
import src.java.poker.app.hand.recognition.JackQueenKing;
import src.java.poker.app.hand.recognition.LowPair;
import src.java.poker.app.hand.recognition.ThreeAces;
import src.java.poker.app.hand.recognition.ThreeOfAKindNotAce;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.Four5KRecognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.missingcards.flush.FourToFlush;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushNoHighCards;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushOneHighCard;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushTwoHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.AKQJUnsuited;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithNoHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithOneHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithThreeHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToInsideStraightWithTwoHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToOutsideStraight;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToRoyalFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToStraightFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.KQJUnsuited;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToRoyalFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToStraightFlushOne;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToStraightFlushThree;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToStraightFlushTwo;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.app.hand.recognition.oneOrTwoCards.Ace;
import src.java.poker.app.hand.recognition.oneOrTwoCards.JTSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.KJ;
import src.java.poker.app.hand.recognition.oneOrTwoCards.KQ;
import src.java.poker.app.hand.recognition.oneOrTwoCards.KTSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.QJSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.QJUnsuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.QTSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.TwoSuitedHighCard;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

/**
 * The Strategy guide behind the simPlayer
 *
 */
public class Brain {
	private List<HandRecognizer> recognizers;

	/**
	 * public Constructor for the brain that make a List of recognizers in a
	 * Priority order from highest to lowest
	 */
	public Brain() {
		this.recognizers = new ArrayList<>();
		/* 1 */
		recognizers.add(new RoyalFlushRecognizer());
		recognizers.add(new FourAcesRecognizer());
		recognizers.add(new Four24Recognizer());
		recognizers.add(new Four5KRecognizer());
		recognizers.add(new StraightFlushRecognizer());
		/* 2 */
		recognizers.add(new FourToRoyalFlush());
		/* 3 */
		recognizers.add(new ThreeAces());
		/* 4 */
		recognizers.add(new StraightRecognizer());
		recognizers.add(new FlushRecognizer());
		recognizers.add(new FullHouseRecognizer());
		/* 5 */
		recognizers.add(new ThreeOfAKindNotAce());
		/* 6 */
		recognizers.add(new FourToStraightFlush());
		/* 7 */
		recognizers.add(new TwoPairRecognizer());
		/* 8 */
		recognizers.add(new HighPair());
		/* 9 */
		recognizers.add(new FourToFlush());
		/* 10 */
		recognizers.add(new ThreeToRoyalFlush());
		/* 11 */
		recognizers.add(new FourToOutsideStraight());

		/* 12 */
		recognizers.add(new LowPair());
		/* 13 */
		recognizers.add(new AKQJUnsuited());
		/* 14 */
		recognizers.add(new ThreeToStraightFlushOne());
		/* 15 */
		recognizers.add(new FourToInsideStraightWithThreeHighCards());
		/* 16 */
		recognizers.add(new QJSuited());
		/* 17 */
		recognizers.add(new ThreeToFlushTwoHighCards());
		/* 18 */
		recognizers.add(new TwoSuitedHighCard());
		/* 19 */
		recognizers.add(new FourToInsideStraightWithTwoHighCards());
		/* 20 */
		recognizers.add(new ThreeToStraightFlushTwo());
		/* 21 */
		recognizers.add(new FourToInsideStraightWithOneHighCards());
		/* 22 */
		recognizers.add(new KQJUnsuited());
		/* 23 */
		recognizers.add(new JTSuited());
		/* 24 */
		recognizers.add(new QJUnsuited());
		/* 25 */
		recognizers.add(new ThreeToFlushOneHighCard());
		/* 26 */
		recognizers.add(new QTSuited());
		/* 27 */
		recognizers.add(new ThreeToStraightFlushThree());
		/* 28 */
		recognizers.add(new KQ());
		recognizers.add(new KJ());

		/* 29 */
		recognizers.add(new Ace());
		/* 30 */
		recognizers.add(new KTSuited());
		/* 31 */
		recognizers.add(new JackQueenKing());
		/* 32 */
		recognizers.add(new FourToInsideStraightWithNoHighCards());
		/* 33 */
		recognizers.add(new ThreeToFlushNoHighCards());
	}
/**
 * 
 * @param hand to be checked 
 * @return PlayerAction
 */
	public PlayerAction getAction(Hand hand) {
		for (HandRecognizer handRecognizer : this.recognizers) {
			if (handRecognizer.recognizeHand(hand).isResult()) {
				return handRecognizer.getAdviceAction(hand);
			}
		}
		return new HoldCardsAction(new ArrayList<>());
	}
}
