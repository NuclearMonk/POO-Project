package src.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import src.java.poker.card.Card;
import src.java.poker.deck.DebugDeck;
import src.java.poker.deck.Deck;
import src.java.poker.deck.Hand;
import src.java.poker.deck.StandardDeck;

/**
 * Main Class
 */
public class Main {
	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Deck deck1 = new StandardDeck();
		deck1.shuffle();
		Hand hand1 = new Hand(deck1);
		System.out.println(deck1.numberOfRemainingCards());
		ArrayList<Integer> indexes = new ArrayList<>(0);
		indexes.add(1);
		indexes.add(2);
		indexes.add(3);
		indexes.add(4);

		System.out.println(hand1.toString());
		hand1.replaceCards(deck1,indexes);
		System.out.println(hand1.toString());
		System.out.println(deck1.numberOfRemainingCards());
		
//		System.out.println("Ordered" + deck1);
//		deck1.shuffle();
//		System.out.println("Shuffled" + deck1);
//		deck1.sort();
//		System.out.println("sorted" + deck1);
//		System.out.println(deck1.numberOfRemainingCards());
//		while (deck1.numberOfRemainingCards() > 0) {
//			List<Card> drawnCards = deck1.drawCard(1);
//			drawnCards.forEach(System.out::println);
//			System.out.println(deck1.numberOfRemainingCards());
//		}
//		System.out.println("Ordered" + deck1.toString());
//
//		File file = new File("Resources\\ExampleFiles\\card-file.txt");
//		try {
//			Deck deck2 = new DebugDeck(file);
//			System.out.println(deck2);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
