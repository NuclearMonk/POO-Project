package src.java;

import java.util.List;

import src.java.deck.Card;
import src.java.deck.Deck;

public class Main {
	public static void main(String[] args) {
    	Deck deck1 = new Deck();
    	System.out.println("Ordered" + deck1.toString());
    	deck1.shuffle();
    	System.out.println("Shuffled" + deck1.toString());
    	System.out.println(deck1.numberOfRemainingCards());
    	while (deck1.numberOfRemainingCards()>0) {			
			List<Card> drawnCards = deck1.drawCard(1);
			drawnCards.forEach(System.out::println);
			System.out.println(deck1.numberOfRemainingCards()); 	
    	}
    	System.out.println("Ordered" + deck1.toString());
	}
}
