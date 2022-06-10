package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.countbased.PairRecognizer;
import src.java.poker.app.hand.recognition.countbased.TrioRecognizer;

public class HandRecognitionTests {
    
    @Test
    public void affirmativePairTest()
    {
        HandRecognizer recognizer = new PairRecognizer();
        Hand hand = new Hand("2H JH 2S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("2H 2C 3S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("TS 2C 3S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("4H KD 3S TC KC");
        assertEquals(true, recognizer.recognizeHand(hand));
    }

    @Test
    public void negativePairTest()
    {
        HandRecognizer recognizer = new PairRecognizer();
        Hand hand = new Hand("2H 2C 2S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("2H AC 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("3S 3C 3H 3D 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("AH AD JS JC JD");
        assertEquals(false, recognizer.recognizeHand(hand));
    }

    @Test
    public void affirmativeTrioTest()
    {
        HandRecognizer recognizer = new TrioRecognizer();
        Hand hand = new Hand("2H 2C 2S TC 9H");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("AH 2C 3S 3C 3H");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("KS 2C KC TC KH");
        assertEquals(true, recognizer.recognizeHand(hand));
        hand = new Hand("AH KD 3S AC AS");
        assertEquals(true, recognizer.recognizeHand(hand));
    }

    @Test
    public void negativeTrioTest()
    {
        HandRecognizer recognizer = new TrioRecognizer();
        Hand hand = new Hand("2H 2C 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("2H AC 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("3S 3C 3H 3D 9H");
        assertEquals(false, recognizer.recognizeHand(hand));
        hand = new Hand("AH AD JS JC JD");
        assertEquals(false, recognizer.recognizeHand(hand));
    }
}
