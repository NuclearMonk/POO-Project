package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToRoyalFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToStraight;
import src.java.poker.app.hand.recognition.missingcards.straight.FourToStraightFlush;
import src.java.poker.app.hand.recognition.missingcards.straight.ThreeToStraight;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;

public class ToStraightRecognitionTests {

    @Test
    public void fourToStraightTest() {
        HandRecognizer recognizer = new FourToStraight();
        Hand hand = new Hand("AH 2H 3H 4H 7H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.ACE, recognizer.recognizeHand(hand).getDefiningCard().getValue());

        hand = new Hand("8H 2H 3H 4H 7H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());

        hand = new Hand("TH JH QH KH 2H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.TEN, recognizer.recognizeHand(hand).getDefiningCard().getValue());

        hand = new Hand("TH JH QH KH AC");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
    }

    @Test
    public void ThreeToStraightTest() {
        HandRecognizer recognizer = new ThreeToStraight();
        Hand hand = new Hand("2H 3H 4H 7H 8C");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(4, recognizer.recognizeHand(hand).getDefiningCard().getValue());
    }

    @Test
    public void fourToStraightFlushTest() {
        HandRecognizer recognizer = new FourToStraightFlush();
        Hand hand = new Hand("2C 3H 4H 7H 6H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(3, recognizer.recognizeHand(hand).getDefiningCard().getValue());

        hand = new Hand("2H 3H 4H 7H 6H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(3, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        assertEquals(Suit.HEARTS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());

        hand = new Hand("2C 3H 4H 7C 6H");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());

        hand = new Hand("TH JH QH KH 2H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.TEN, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        assertEquals(Suit.HEARTS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());

        hand = new Hand("TH JH QH KH AC");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.TEN, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        assertEquals(Suit.HEARTS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());
    }

    @Test
    public void fourToRoyalFlushTest() {
        HandRecognizer recognizer = new FourToRoyalFlush();
        Hand hand = new Hand("TH JH QH KH 2H");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.TEN, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        assertEquals(Suit.HEARTS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());

        hand = new Hand("TH JH QH KH AC");
        assertEquals(true, recognizer.recognizeHand(hand).isResult());
        assertEquals(Card.TEN, recognizer.recognizeHand(hand).getDefiningCard().getValue());
        assertEquals(Suit.HEARTS, recognizer.recognizeHand(hand).getDefiningCard().getSuit());

        hand = new Hand("TH JH QH KH AH");
        assertEquals(false, recognizer.recognizeHand(hand).isResult());
    }

}
