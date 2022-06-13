package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.analyzer.StraightFlush4OfKindRoyalFlush;
import src.java.poker.app.hand.analyzer.StraightOrFlushFullHouse;
import src.java.poker.app.hand.analyzer.ThreeAces;
import src.java.poker.app.hand.analyzer.ThreeOfAKindNotAce;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.ThreeOfARecognizer;

class HandAnalyzerTesr {

	@Test
	public void affirmativeStraightFlush4OfKindRoyalFlush() {
		HandRecognizer recognizer = new StraightFlush4OfKindRoyalFlush();
		Hand hand = new Hand("AH 2H 3H 4H 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH 2H 3H 4H 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AS KS QS TS JS");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH KD 3S AC AS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH AD AS AC KS");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH KD QH JH TH");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH KD 3S AC AS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
	}
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
	public void affirmativeStraightOrFlushFullHouse() {
		HandRecognizer recognizer = new StraightOrFlushFullHouse();
		Hand hand = new Hand("AH 2D 3H 4H 5H");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH AD AS 4H 4S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("4S KS 3S TS JS");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH KD 3S AC AS");
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

}