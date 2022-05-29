package src.java;

import src.java.deck.Deck;

public class Main {
    public static void main(String[] args) {
    	Deck D1 = new Deck();
    	System.out.println("Orderd" + D1.toString());
    	D1.shuffle();
    	System.out.println("Shuffled" + D1.toString());
    	System.out.println(D1.numberOfRemainingCards());
    	for(int i = 1; i <= 52 ; i++) {
    	System.out.println(D1.drawCard(1).toString());
    	System.out.println(D1.numberOfRemainingCards()); 
    }
    	System.out.println("Orderd" + D1.toString());
    }
}
