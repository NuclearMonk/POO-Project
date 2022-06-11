package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.countbased.TwoOfAKindRecognizer;
import src.java.poker.app.hand.recognition.countbased.Four24Recognizer;
import src.java.poker.app.hand.recognition.countbased.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.countbased.FourOfAKindRecognizer;
import src.java.poker.app.hand.recognition.countbased.JacksOrBetterRecognizer;
import src.java.poker.app.hand.recognition.countbased.ThreeOfARecognizer;

public class HandRecognitionTests {
    
    @Test
    public void affirmativeTwoOfAKindTest()
    {
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
    public void negativeTwoOfAKindTest()
    {
        HandRecognizer recognizer = new TwoOfAKindRecognizer();
        Hand hand = new Hand("2H 2C 2S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H AC 3S TC 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3S 3C 3H 3D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AD JS JC JD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void affirmativeThreeOfAKindTest()
    {
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
    public void negativeThreeOfAKindTest()
    {
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
    public void FourAcesRecognizerTests()
    {
        HandRecognizer recognizer = new FourAcesRecognizer();
        Hand hand = new Hand("2H 2C 2S 2D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("5H 5C 5S 5D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("AH AC AS TC AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void Four24RecognizerTests()
    {
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
    public void JackOrBetterRecognizerTests()
    {
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
}
