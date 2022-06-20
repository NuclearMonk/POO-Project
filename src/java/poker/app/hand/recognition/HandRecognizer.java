package src.java.poker.app.hand.recognition;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;
/**
 * HandRecognizer that implement HandAction interface to recognize what hand it is 
 *
 */
public abstract class HandRecognizer implements HandAction {
	protected final String handName;
	protected final int rewardMultiplier;

	/**
	 * Protected Constructor for the abstract class
	 * 
	 * @param handName to be given to the hand
	 * @param rewardMultiplier equal to the factor that the bet is multiplay by
	 */
	protected HandRecognizer(String handName, int rewardMultiplier) {
		this.handName = handName;
		this.rewardMultiplier = rewardMultiplier;
	}

	/**
	 * getter for the rewardMultiplier
	 * @return rewardMultiplier
	 */
	public int getRewardMultiplier() {
		return rewardMultiplier;
	}

	/**
	 * Abstract method
	 * @param hand to deal with
	 * @return HandRecognitionResult
	 */
	public abstract HandRecognitionResult recognizeHand(Hand hand);

	/**
	 * getter for the handName
	 * @return handName
	 */
	public String getHandName() {
		return handName;
	}

	/**
	 * @param hand to give the action according to 
	 * @return PlayerAction
	 */
	@Override
	public PlayerAction getAdviceAction(Hand hand) {
		return null;
	}

	public Integer getFullPayReward()
	{
		return 5*rewardMultiplier;
	}

}
