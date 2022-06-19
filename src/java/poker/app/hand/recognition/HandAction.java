package src.java.poker.app.hand.recognition;
/**
 * interface  for HandAction
 */
import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;

public interface HandAction {
	/**
	 * 
	 * @param hand to give according to this hand
	 * @return PlayerAction
	 */
	public PlayerAction getAdviceAction(Hand hand);
	
}
