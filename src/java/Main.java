package src.java;

import src.java.deck.Card;
import src.java.deck.Suit;

public class Main {
    public static void main(String[] args) {
        for (Suit suit : Suit.values()) {         
            for (int i = 1; i <= 13; i++) {                
                Card card = new Card(i, suit);
                System.out.println(card);
            }   
        }
    }
}
