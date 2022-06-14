package src.java.poker.app.hand.recognition;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;

public interface HandAction {
	public PlayerAction getAdviceAction(Hand hand);
	
}
