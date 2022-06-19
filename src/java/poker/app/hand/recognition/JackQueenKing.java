package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;
/**
 *
 * To recognize if the hand has Jack, Queen or King
 *
 */
public class JackQueenKing extends HandRecognizer {
	/**
	 * Public Constructor that set handName to "Jack Queen King" and
	 * rewardsMultiplayer to 0
	 */

	public JackQueenKing() {
		super("Jack Queen King", 0);
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
	 * Recognizing Where there are Jack, Queen or Kind inside the hand
	 * @return HandRecognitionResult
	 * @param hand to check
	 */
	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		for (Card C : hand.cardsAsList()) {
			if (C.getValue() >= Card.JACK)
				return new HandRecognitionResult(true, C);
		}
		return new HandRecognitionResult(false, null);
	}

}
