package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.analyzer.HighPair;
import src.java.poker.app.hand.analyzer.LowPair;
import src.java.poker.app.hand.analyzer.ThreeAces;
import src.java.poker.app.hand.analyzer.ThreeOfAKindNotAce;
import src.java.poker.app.hand.analyzer.TwoPairs;
import src.java.poker.app.hand.analyzer.TwoSuitedHighCard;
import src.java.poker.app.hand.analyzer.missingCards.FourToFlush;
import src.java.poker.app.hand.analyzer.missingCards.ThreeToFlushNoHighCards;
import src.java.poker.app.hand.analyzer.missingCards.ThreeToFlushTwoHighCards;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

class HandAnalyzerTesr {

	@Test
	public void affirmativeThreeAces() {
		HandRecognizer recognizer = new ThreeAces();
		Hand hand = new Hand("AH AH AH 4H 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH KH KH 4H 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AS AH AD AC JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}

	@Test
	public void affirmativeOfAKindNotAce() {
		HandRecognizer recognizer = new ThreeOfAKindNotAce();
		Hand hand = new Hand("AH AH AH 4H 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH KH KH 4H 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KS KH KD KC JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}

	@Test
	public void affirmativeTwoPairs() {
		HandRecognizer recognizer = new TwoPairs();
		Hand hand = new Hand("AH AH TH TH 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH KH KH 4H 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KS KH QD QC QS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}

	@Test
	public void affirmativeHighPairs() {
		HandRecognizer recognizer = new HighPair();
		Hand hand = new Hand("AH AH TH QH 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH KH KH 4H 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("JS JH TD QC JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 5H TD QC JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}

	@Test
	public void affirmativeLowPairs() {
		HandRecognizer recognizer = new LowPair();
		Hand hand = new Hand("AH AH QH TH 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH KH KH 4H 5H");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KS KH TD QC JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 5H TD QC JS");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());

	}
	
	@Test
	public void affirmativeFourToFlush() {
		HandRecognizer recognizer = new FourToFlush();
		Hand hand = new Hand("AH AS TH TH 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH QH JH 4H 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KS QS AS 4H 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH QS AS 4H 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());



	}
	@Test
	public void affirmativeThreeToFlushTwoHighCards() {
		HandRecognizer recognizer = new ThreeToFlushTwoHighCards();
		Hand hand = new Hand("KH QH 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KH TH 4H 6H 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH QH 6H 6C 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());

	}
	@Test
	public void affirmativeTwoSuitedHighCard() {
		HandRecognizer recognizer = new TwoSuitedHighCard();
		Hand hand = new Hand("KH QH 2D TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH JH 4C 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AS QC JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	@Test
	public void affirmativeThreeToFlushNoHighCards() {
		HandRecognizer recognizer = new ThreeToFlushNoHighCards();
		Hand hand = new Hand("AH 4H 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AD JD 4D 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AS QC JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	
}