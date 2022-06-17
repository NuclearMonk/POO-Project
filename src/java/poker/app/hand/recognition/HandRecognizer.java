package src.java.poker.app.hand.recognition;

import src.java.poker.app.hand.Hand;
import src.java.poker.player.actions.PlayerAction;

public abstract class HandRecognizer  implements HandAction{
    protected final String handName;
    protected final int rewardMultiplier;
    protected HandRecognizer(String handName, int rewardMultiplier) {
        this.handName = handName;
        this.rewardMultiplier = rewardMultiplier;
    }
    public int getRewardMultiplier() {
        return rewardMultiplier;
    }
    public abstract HandRecognitionResult recognizeHand(Hand hand);

    public String getHandName()
    {
        return handName;
    }
    
    @Override
    public PlayerAction getAdviceAction(Hand hand) {
        return null;
    }
    

}
