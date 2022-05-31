package src.java.poker.deck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import src.java.poker.card.Card;

/**
 * A debug File input based deck
 */
public class DebugDeck extends Deck {
    /**
     * Constructs a new deck of from a card file
     * 
     * @param file the file to be read
     * @throws FileNotFoundException if the scanner fails to find the file
     */
    public DebugDeck(File file) throws FileNotFoundException {
        this.cards = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext(Pattern.compile(Card.CARD_REGEX))) {
                String token = scanner.next(Pattern.compile(Card.CARD_REGEX));
                Card card = new Card(token);
                this.cards.add(card);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file doesn't exist");
        }

    }
}
