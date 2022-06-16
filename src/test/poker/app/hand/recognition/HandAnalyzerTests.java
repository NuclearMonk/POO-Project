package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.HighPair;
import src.java.poker.app.hand.recognition.JackQueenKing;
import src.java.poker.app.hand.recognition.LowPair;
import src.java.poker.app.hand.recognition.ThreeAces;
import src.java.poker.app.hand.recognition.ThreeOfAKindNotAce;
import src.java.poker.app.hand.recognition.missingcards.flush.FourToFlush;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushNoHighCards;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushOneHighCard;
import src.java.poker.app.hand.recognition.missingcards.flush.ThreeToFlushTwoHighCards;
import src.java.poker.app.hand.recognition.missingcards.straight.AKQJUnsuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.JTSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.KQorKJ;
import src.java.poker.app.hand.recognition.oneOrTwoCards.KTSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.QJSuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.QJunsuited;
import src.java.poker.app.hand.recognition.oneOrTwoCards.TwoSuitedHighCard;


public class HandAnalyzerTests {

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
	@Test
	public void affirmativeThreeToFlushOneHighCard() {
		HandRecognizer recognizer = new ThreeToFlushOneHighCard();
		Hand hand = new Hand("AH 4H 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AD JD 4D 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	@Test
	public void affirmativeQJSuited() {
		HandRecognizer recognizer = new QJSuited();
		Hand hand = new Hand("QH JH 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("QD JC 4D 6S 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	
	@Test
	public void affirmativeJTSuited() {
		HandRecognizer recognizer = new JTSuited();
		Hand hand = new Hand("TH JH 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("TD JC 4D 6S 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	
	@Test
	public void affirmativeKTSuited() {
		HandRecognizer recognizer = new KTSuited();
		Hand hand = new Hand("TH KH 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("TD KC 4D 6S 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	
	@Test
	public void affirmativeJackQueenKing() {
		HandRecognizer recognizer = new JackQueenKing();
		Hand hand = new Hand("TH KH 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("TD QC 4D 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S TH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	@Test
	public void affirmativeKQorKJ() {
		HandRecognizer recognizer = new KQorKJ();
		Hand hand = new Hand("KH QD 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KD JD 4D 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S KS TH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}

	public void affirmativeQJunsuited() {
		HandRecognizer recognizer = new QJunsuited();
		Hand hand = new Hand("KH QD 2H TS 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("KD JD 4D 6S 5S");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S 4S JH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("5S KS TH 6C 5S");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}
	
	public void affirmativeAKQJUnsuited() {
		HandRecognizer recognizer = new AKQJUnsuited();
		Hand hand = new Hand("KS AS QS 3S JH");
		assertEquals(true, recognizer.recognizeHand(hand).isResult());
		hand = new Hand("AH KD KH 3S JS");
		assertEquals(false, recognizer.recognizeHand(hand).isResult());

	}	
}