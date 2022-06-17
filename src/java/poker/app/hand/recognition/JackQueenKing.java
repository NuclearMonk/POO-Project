package src.java.poker.app.hand.recognition;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class JackQueenKing extends HandRecognizer {

	public JackQueenKing() {
		super("Jack Queen King", 0);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue(),
				this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		for (Card C : hand.cardsAsList())
		{
			if(C.getValue()>=Card.JACK)
				return new HandRecognitionResult(true, C); 
		}
		return new HandRecognitionResult(false, null);
	}

}
