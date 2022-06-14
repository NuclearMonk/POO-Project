package src.java.poker.app.hand.analyzer;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public class JackQueenKing extends HandRecognizer implements HandAction {

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		int index = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getValue(), this.recognizeHand(hand).getDefiningCard().getSuit());
		
		return new HoldCardsAction(index);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}

}
