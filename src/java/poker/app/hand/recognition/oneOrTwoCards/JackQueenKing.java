package src.java.poker.app.hand.recognition.oneOrTwoCards;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class JackQueenKing extends HandRecognizer {
	/**
	 * Protected Constructor that set handName to "Jack Queen or King" and
	 * rewardMultiplayer to 0
	 */
	protected JackQueenKing() {
		super("Jack Queen or King", 0);
	}

	/**
	 * @param Hand to give the action according to
	 * @return PlayerAction to hold the Cards that match the class criterion
	 */

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue(),
				this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	/**
	 * Recognizing Where the hand has Jack, Queen or King
	 * 
	 * @param Hand to be checked
	 * @return HandRecognitionResult
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() < Card.ACE) {
				return new HandRecognitionResult(true, C);
			}
		}
		return new HandRecognitionResult(false, null);
	}

}
