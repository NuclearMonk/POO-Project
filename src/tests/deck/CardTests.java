package src.tests.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import src.java.deck.Card;
import src.java.deck.Suit;

public class CardTests {
    
    @Test
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
    public void invalidCardValueShouldThrow()
    {
        assertThrows(IllegalArgumentException.class, () -> new Card(-1,Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(0,Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(14,Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(Integer.MIN_VALUE ,Suit.SPADES));
        assertThrows(IllegalArgumentException.class, () -> new Card(Integer.MAX_VALUE ,Suit.SPADES));
    }
    
}
