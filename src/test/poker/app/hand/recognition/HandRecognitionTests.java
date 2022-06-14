package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.count.JacksOrBetterRecognizer;
import src.java.poker.app.hand.recognition.count.ThreeOfARecognizer;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;

public class HandRecognitionTests {


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

    @Test
    public void twoPairRecognizerTests() {
        HandRecognizer recognizer = new TwoPairRecognizer();
        Hand hand = new Hand("JH JC 2S 2C 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.JACK, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("AS AC JH JC 4D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("2H 2C 2S 2D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("TH TC 2S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("QH QC 2S 2C 2D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("KH KC KS 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void fullHouseRecognizerTests() {
        HandRecognizer recognizer = new FullHouseRecognizer();
        Hand hand = new Hand("JH JC 2S 2C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("2H 2C 2S 2D 9H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("TH TC 2S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("QH QC 2S 2C 2D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(2, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("KH KC KS 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void straightRecognizerTests() {
        HandRecognizer recognizer = new StraightRecognizer();
        Hand hand = new Hand("JH JC 3S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 5S 6C 7D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 5S AC 2D");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(5, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("JH QC KS KC AD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("JH QC KS TC AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("3H 4C 5S 6C 6D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 8S 6C 7D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 3C 5S 6C 7D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void straightFlushRecognizerTests() {
        HandRecognizer recognizer = new StraightFlushRecognizer();
        Hand hand = new Hand("JH JC 3S 3C 4D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 5S 6C 7D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3C 4C 5C 6C 7C");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3S 4S 5S AS 2S");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(5, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("3H 4C 5S AC 2D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("JH QC KS KC AD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("JD QD KD TD AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        hand = new Hand("JH QC KS TC AD");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 5S 6C 6D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 4C 8S 6C 7D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3H 3C 5S 6C 7D");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void royalFlushRecognizerTests() {
        HandRecognizer recognizer = new RoyalFlushRecognizer();
        Hand hand = new Hand("3C 4C 5C 6C 7C");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("3S 4S 5S AS 2S");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
        hand = new Hand("JD QD KD TD AD");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());
    }
}
