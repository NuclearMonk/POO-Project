package src.java.poker.app.hand.analyzer;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.HandRecognitionResult;

public abstract class HandAnalyzer {
	protected final String handName;

	protected HandAnalyzer(String handName) {
		this.handName = handName;
	}

	public abstract HandRecognitionResult recognizeHand(Hand hand);

	public String getHandName() {
		return handName;
	}

}