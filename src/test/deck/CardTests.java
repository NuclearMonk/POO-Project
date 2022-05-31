package src.test.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import src.java.poker.card.Card;
import src.java.poker.card.Suit;
/**
 * A class fpr holding tests related to card behavior
 */
public class CardTests {

    @Test
    /**
     * A simple test
     */
    public void aceOfClubsIsAC() {
        assertEquals(new Card(Card.ACE, Suit.CLUBS).toString(), "AC");
    }

    @Test
    public void aceOfDiamondsIsAD() {
        assertEquals(new Card(Card.ACE, Suit.DIAMONDS).toString(), "AD");
    }

    @Test
    public void aceOfHeartsIsAH() {
        assertEquals(new Card(Card.ACE, Suit.HEARTS).toString(), "AH");
    }

    @Test
    public void aceOfSpadesIsAS() {
        assertEquals(new Card(Card.ACE, Suit.SPADES).toString(), "AS");
    }

    @Test
    public void tenOfSpadesIsTS() {
        assertEquals(new Card(Card.TEN, Suit.SPADES).toString(), "TS");
    }

    @Test
    public void jackOfSpadesIsJS() {
        assertEquals(new Card(Card.JACK, Suit.SPADES).toString(), "JS");
    }

    @Test
    public void queenOfSpadesIsQS() {
        assertEquals(new Card(Card.QUEEN, Suit.SPADES).toString(), "QS");
    }

    @Test
    public void kingOfSpadesIsKS() {
        assertEquals(new Card(Card.KING, Suit.SPADES).toString(), "KS");
    }

    @Test
    public void twoOfSpadesIs2S() {
        assertEquals(new Card(2, Suit.SPADES).toString(), "2S");
    }

    @Test
    public void invalidCardValueShouldThrowTest() {
        assertThrows(IllegalArgumentException.class, () -> new Card(-1, Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(0, Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(14, Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(Integer.MIN_VALUE, Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(Integer.MAX_VALUE, Suit.SPADES));
    }

    @Test
    public void cardValueReadTest() {
        assertEquals(Card.ACE, new Card("AS").getValue());
        assertEquals(2, new Card("2S").getValue());
        assertEquals(3, new Card("3S").getValue());
        assertEquals(4, new Card("4S").getValue());
        assertEquals(5, new Card("5S").getValue());
        assertEquals(6, new Card("6S").getValue());
        assertEquals(7, new Card("7S").getValue());
        assertEquals(8, new Card("8S").getValue());
        assertEquals(9, new Card("9S").getValue());
        assertEquals(Card.TEN, new Card("TS").getValue());
        assertEquals(Card.JACK, new Card("JS").getValue());
        assertEquals(Card.QUEEN, new Card("QS").getValue());
        assertEquals(Card.KING, new Card("KS").getValue());
    }

    @Test
    public void cardSuitReadTest() {
        assertEquals(Suit.CLUBS, new Card("AC").getSuit());
        assertEquals(Suit.DIAMONDS, new Card("AD").getSuit());
        assertEquals(Suit.HEARTS, new Card("AH").getSuit());
        assertEquals(Suit.SPADES, new Card("AS").getSuit());
        assertEquals(Suit.CLUBS, new Card("2C").getSuit());
        assertEquals(Suit.DIAMONDS, new Card("3D").getSuit());
        assertEquals(Suit.HEARTS, new Card("7H").getSuit());
        assertEquals(Suit.SPADES, new Card("9S").getSuit());
        assertEquals(Suit.CLUBS, new Card("TC").getSuit());
        assertEquals(Suit.DIAMONDS, new Card("TD").getSuit());
        assertEquals(Suit.HEARTS, new Card("TH").getSuit());
        assertEquals(Suit.SPADES, new Card("TS").getSuit());
        assertEquals(Suit.CLUBS, new Card("KC").getSuit());
        assertEquals(Suit.DIAMONDS, new Card("KD").getSuit());
        assertEquals(Suit.HEARTS, new Card("KH").getSuit());
        assertEquals(Suit.SPADES, new Card("KS").getSuit());
    }

    @Test
    public void invalidCardStringShouldThrowTest() {
        assertThrows(IllegalArgumentException.class, () -> new Card("aS"));
        assertThrows(IllegalArgumentException.class, () -> new Card("ASS"));
        assertThrows(IllegalArgumentException.class, () -> new Card(""));
        assertThrows(IllegalArgumentException.class, () -> new Card(null));
        assertThrows(IllegalArgumentException.class, () -> new Card("QP"));
        assertThrows(IllegalArgumentException.class, () -> new Card(" BC "));
    }
}
