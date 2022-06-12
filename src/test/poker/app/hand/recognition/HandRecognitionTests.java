package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.countbased.TwoOfAKindRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.app.hand.recognition.countbased.Four24Recognizer;
import src.java.poker.app.hand.recognition.countbased.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.countbased.FourOfAKindRecognizer;
import src.java.poker.app.hand.recognition.countbased.JacksOrBetterRecognizer;
import src.java.poker.app.hand.recognition.countbased.ThreeOfARecognizer;

public class HandRecognitionTests {

    @Test
    public void affirmativeTwoOfAKindTest() {
        HandRecognizer recognizer = new TwoOfAKindRecognizer();
        Hand hand = new Hand("2H JH 2S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H 2C 3S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("TS 2C 3S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("4H KD 3S TC KC");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void negativeTwoOfAKindTest() {
        HandRecognizer recognizer = new TwoOfAKindRecognizer();
        Hand hand = new Hand("2H 2C 2S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H AC 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3S 3C 3H 3D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AD JS JC JD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AS AC JH JD KD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void affirmativeThreeOfAKindTest() {
        HandRecognizer recognizer = new ThreeOfARecognizer();
        Hand hand = new Hand("2H 2C 2S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH 2C 3S 3C 3H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("KS 2C KC TC KH");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH KD 3S AC AS");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void negativeThreeOfAKindTest() {
        HandRecognizer recognizer = new ThreeOfARecognizer();
        Hand hand = new Hand("2H 2C 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H AC 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3S 3C 3H 3D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AD JS JC JD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void fourAcesRecognizerTests() {
        HandRecognizer recognizer = new FourAcesRecognizer();
        Hand hand = new Hand("2H 2C 2S 2D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("5H 5C 5S 5D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AC AS TC AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void four24RecognizerTests() {
        HandRecognizer recognizer = new Four24Recognizer();
        Hand hand = new Hand("AH AC AS TC AD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H 2C 2S 2D 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 3C 3S 3D 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("4H 4C 4S 4D 9H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("5H 5C 5S 5D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void jackOrBetterRecognizerTests() {
        HandRecognizer recognizer = new JacksOrBetterRecognizer();
        Hand hand = new Hand("TH TC 2S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("JH JC 2S 3C 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("QH QC 2S 3C 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("KH KC 2S 3C 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AC 2S 3C 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("6H 2C 2S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void flushRecognizerTests() {
        HandRecognizer recognizer = new FlushRecognizer();
        Hand hand = new Hand("2C 3C 7C 9C AC");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Suit.CLUBS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("2D 3D 7D 9D AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Suit.DIAMONDS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("2C 3C 7C 9C AD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }
}
