package src.java.poker.player.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;

public class HoldCardsAction implements PlayerAction {
	private List<Integer> indexes;

	/**
	 * Public Constructor
	 * 
	 * @param indexes of the cards to be held
	 */

	public HoldCardsAction(List<Integer> indexes) {
		Collections.sort(indexes);
		this.indexes = indexes;
	}

	/**
	 * Do the action of keeping the cards with indexes that matches indexes
	 * Attribute
	 */
	@Override
	public void doAction(App app) {
		if (app == null) {
			throw new NullPointerException("app can't be null");
		}
		ArrayList<Integer> swapIndexes = new ArrayList<>();
		for (int i = 0; i < Hand.HAND_SIZE; i++) {
			if (!indexes.contains(i)) {
				swapIndexes.add(i);
			}
		}
		app.getHand().replaceCards(app.getDeck(), swapIndexes);
		if(app.getStream()!=null)
		{
			app.getStream().println("player's Hand " + app.getHand());
		}
		app.afterRoundProcessing();
	}

	/**
	 * @return hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indexes == null) ? 0 : indexes.hashCode());
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.\
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoldCardsAction other = (HoldCardsAction) obj;
		if (indexes == null) {
			if (other.indexes != null)
				return false;
		} else if (!indexes.equals(other.indexes))
			return false;
		return true;
	}
/**
 * @return String
 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("hold");
		for (Integer index : this.indexes) {
			stringBuilder.append(" ");
			stringBuilder.append(index + 1);
		}
		return stringBuilder.toString();
	}
}
