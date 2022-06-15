package src.test.poker.app.hand.recognition;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.missingcards.straight.ToStraight;
import src.java.poker.card.Card;

public class MissingFlushRecognitionTests {

    @Test
    public void fourToFlushTest() {
        Hand hand = new Hand("AH 2H 3H 4H 7H");
        List<Integer> result = ToStraight.getGaps(hand);
        assertEquals(4, result.size());

        hand = new Hand("9H TH JH KH 2C");
        result = ToStraight.getGaps(hand);
        assertEquals(4, result.size());
        assertEquals(9, result.get(0).intValue());
        assertEquals(Card.TEN, result.get(1).intValue());
        assertEquals(Card.JACK, result.get(2).intValue());
        assertEquals(Card.KING, result.get(3).intValue());

    }

    @Test
    public void ThreeToStraightTest() {
        Hand hand = new Hand("2H 3H 4H 7H 8C");
        List<Integer> result = ToStraight.getGaps(hand);
        assertEquals(3, result.size());
        assertEquals(4, result.get(0).intValue());
        assertEquals(7, result.get(1).intValue());
        assertEquals(8, result.get(2).intValue());
    }

    @Test
    public void RoyalFlushEdgeCaseTest() {
        Hand hand = new Hand("AH QH JH KH 2C");
        List<Integer> result = ToStraight.getGaps(hand);
        assertEquals(4, result.size());
        assertEquals(Card.JACK, result.get(0).intValue());
        assertEquals(Card.QUEEN, result.get(1).intValue());
        assertEquals(Card.KING, result.get(2).intValue());
        assertEquals(Card.ACE, result.get(3).intValue());

        hand = new Hand("TH QH JH KH 2C");
        result = ToStraight.getGaps(hand);
        assertEquals(4, result.size());
        assertEquals(Card.TEN, result.get(0).intValue());
        assertEquals(Card.JACK, result.get(1).intValue());
        assertEquals(Card.QUEEN, result.get(2).intValue());
        assertEquals(Card.KING, result.get(3).intValue());
    }
}
