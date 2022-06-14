package src.java.poker.app.hand.analyzer;

import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class FourtoStraight extends HandRecognizer implements HandAction {

	protected FourtoStraight() {
		super("Four to Stragiht", 0);
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Card> unWantedCard = hand.findCards(this.recognizeHand(hand).getDefiningCard().getValue(),
				this.recognizeHand(hand).getDefiningCard().getSuit());
		List<Integer> wantedCardIndex = null;
		for (int i = 0; i<5; i++)
		{
			for (Card C : unWantedCard)
			if(!hand.getCardByIndex(i).equals(C))
			{
				wantedCardIndex.add(i);
			}
		}
		return new HoldCardsAction(wantedCardIndex);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}

}
