package src.java.poker.app.hand.recognition;

import src.java.poker.card.Card;

public class HandRecognitionResult {
    private final boolean result;
    private final Card definingCard;
    public HandRecognitionResult(boolean result, Card definingCard) {
        this.result = result;
        this.definingCard = definingCard;
    }
    public boolean isResult() {
        return result;
    }
    public Card getDefiningCard() {
        return definingCard;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((definingCard == null) ? 0 : definingCard.hashCode());
        result = prime * result + (this.result ? 1231 : 1237);
        return result;
    }
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
