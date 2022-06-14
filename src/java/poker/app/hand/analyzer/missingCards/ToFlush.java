package src.java.poker.app.hand.analyzer.missingCards;

import java.util.Collections;
import java.util.List;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.analyzer.HandAction;
import src.java.poker.app.hand.recognition.HandRecognitionResult;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.card.Card;
import src.java.poker.card.Suit;
import src.java.poker.player.actions.HoldCardsAction;
import src.java.poker.player.actions.PlayerAction;

public abstract class ToFlush extends HandRecognizer implements HandAction {

	protected int toFlush;

	protected ToFlush(String handName, int rewardMultiplier, int toFlush) {
		super(handName, rewardMultiplier);
		this.toFlush = toFlush;
	}

	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		List<Integer> indexes = hand.getCardIndex(this.recognizeHand(hand).getDefiningCard().getSuit());
		return new HoldCardsAction(indexes);
	}

	@Override
	public HandRecognitionResult recognizeHand(Hand hand) {
		Boolean result = false;
		Card definingCard = null;
		for (Card C : hand.cardsAsList()) {

			Integer handCount = hand.findCards(C.getSuit()).size();

			if (handCount == this.toFlush) {
				result = true;
				List<Card> handList = hand.cardsAsList();
				Collections.sort(handList); // sort the hand from lowest tom highest
				Collections.reverse(handList); // reverse the hant to get highest to lowest
				if (handList.get(0).getSuit().equals(C.getSuit()))
					definingCard = handList.get(0);
				else if (handList.get(1).getSuit().equals(C.getSuit()))
					definingCard = handList.get(1);
				else
					definingCard = handList.get(2);
				break;
			}
		}
		return new HandRecognitionResult(result, definingCard);

	}

}
