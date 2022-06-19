package src.java.poker.app.hand.recognition;

import src.java.poker.card.Card;
/**
 * Class to keep the result for hand recognition process
 *
 */
public class HandRecognitionResult {
	private final boolean result;
	private final Card definingCard;

	/**
	 * Public Constructor of the class
	 * 
	 * @param result
	 * @param definingCard
	 */
	public HandRecognitionResult(boolean result, Card definingCard) {
		this.result = result;
		this.definingCard = definingCard;
	}

	/**
	 * 
	 * @return result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * 
	 * @return definingCard which define the hand
	 */
	public Card getDefiningCard() {
		return definingCard;
	}

	/**
	 * @return result hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((definingCard == null) ? 0 : definingCard.hashCode());
		result = prime * result + (this.result ? 1231 : 1237);
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
		HandRecognitionResult other = (HandRecognitionResult) obj;
		if (definingCard == null) {
			if (other.definingCard != null)
				return false;
		} else if (!definingCard.equals(other.definingCard))
			return false;
		if (result != other.result)
			return false;
		return true;
	}
}
