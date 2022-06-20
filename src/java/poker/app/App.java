package src.java.poker.app;

import java.io.PrintStream;
import java.util.ArrayList;

import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.FlushRecognizer;
import src.java.poker.app.hand.recognition.HandRecognizer;
import src.java.poker.app.hand.recognition.count.Four24Recognizer;
import src.java.poker.app.hand.recognition.count.Four5KRecognizer;
import src.java.poker.app.hand.recognition.count.FourAcesRecognizer;
import src.java.poker.app.hand.recognition.count.JacksOrBetterRecognizer;
import src.java.poker.app.hand.recognition.count.ThreeOfARecognizer;
import src.java.poker.app.hand.recognition.multiple.FullHouseRecognizer;
import src.java.poker.app.hand.recognition.multiple.TwoPairRecognizer;
import src.java.poker.app.hand.recognition.sequence.RoyalFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightFlushRecognizer;
import src.java.poker.app.hand.recognition.sequence.StraightRecognizer;
import src.java.poker.app.stats.StatsManager;
import src.java.poker.deck.Deck;
import src.java.poker.player.Player;
import src.java.poker.player.actions.PlayerAction;

/**
 * main app class with Player, Deck and Hand attribute
 */
public class App {
	private final Player player;
	private final PrintStream stream;

	/**
	 * 
	 * @return the output stream, may be null to mute the output logs
	 */
	public PrintStream getStream() {
		return stream;
	}

	/**
	 * 
	 * @return player which has been defined inside the App
	 */

	public Player getPlayer() {
		return player;
	}

	private final Deck deck;

	/**
	 * 
	 * @return deck which has been defined inside the App
	 */
	public Deck getDeck() {
		return deck;
	}

	private Hand hand;

	/**
	 * Setter for the hand
	 * 
	 * @param hand the current player is playing
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * 
	 * @return hand current hand the player is playing
	 */
	public Hand getHand() {
		return hand;
	}

	private int ongoingBetAmount = 0;

	/**
	 * 
	 * @return ongoingBetAmount that the player is betting
	 */
	public int getOngoingBetAmount() {
		return ongoingBetAmount;
	}

	/**
	 * 
	 * @param ongoingBetAmount to be set as the current bet
	 */

	public void setOngoingBetAmount(int ongoingBetAmount) {
		sumOfBets += ongoingBetAmount;
		this.ongoingBetAmount = ongoingBetAmount;
	}

	private ArrayList<HandRecognizer> recognizers;

	private Integer handCount = 0;
	private Integer sumOfGains = 0;
	private Integer sumOfBets = 0;

	/**
	 * 
	 * @return sum of all bets the player has bet
	 */
	public Integer getSumOfBets() {
		return sumOfBets;
	}

	/**
	 * 
	 * @return sum of all gains the player got
	 */
	public Integer getSumOfGains() {
		return sumOfGains;
	}

	/**
	 * 
	 * @param handCount the number of hands that have been played
	 */
	public void setHandCount(Integer handCount) {
		this.handCount = handCount;
	}

	/**
	 * 
	 * @return hand count
	 */
	public Integer getHandCount() {
		return handCount;
	}

	/**
	 * A public constructor for the App
	 * 
	 * @param player who will play
	 * @param deck   which will be used to deal cards
	 * @param stream output stream of logs, set to null to mute optional outputs
	 */
	public App(Player player, Deck deck, PrintStream stream) {
		this.player = player;
		this.deck = deck;
		this.stream = stream;
		recognizers = new ArrayList<>();
		StatsManager.addStatsItem(9, "Royal Flush");
		HandRecognizer hr = new RoyalFlushRecognizer();
		StatsManager.addTrackedRecognizer(hr, 9);
		recognizers.add(hr);

		StatsManager.addStatsItem(8, "Straight Flush");
		hr = new StraightFlushRecognizer();
		StatsManager.addTrackedRecognizer(hr, 8);
		recognizers.add(hr);

		StatsManager.addStatsItem(7, "Four Of a Kind");
		hr = new FourAcesRecognizer();
		StatsManager.addTrackedRecognizer(hr, 7);
		recognizers.add(hr);
		hr = new Four24Recognizer();
		StatsManager.addTrackedRecognizer(hr, 7);
		recognizers.add(hr);
		hr = new Four5KRecognizer();
		StatsManager.addTrackedRecognizer(hr, 7);
		recognizers.add(hr);

		StatsManager.addStatsItem(6, "Full house");
		hr = new FullHouseRecognizer();
		StatsManager.addTrackedRecognizer(hr, 6);
		recognizers.add(hr);

		StatsManager.addStatsItem(5, "Flush");
		hr = new FlushRecognizer();
		StatsManager.addTrackedRecognizer(hr, 5);
		recognizers.add(hr);

		StatsManager.addStatsItem(4, "Straight");
		hr = new StraightRecognizer();
		StatsManager.addTrackedRecognizer(hr, 4);
		recognizers.add(hr);

		StatsManager.addStatsItem(3, "Three of a Kind");
		hr = new ThreeOfARecognizer();
		StatsManager.addTrackedRecognizer(hr, 3);
		recognizers.add(hr);

		StatsManager.addStatsItem(2, "Two Pair");
		hr = new TwoPairRecognizer();
		StatsManager.addTrackedRecognizer(hr, 2);
		recognizers.add(hr);

		StatsManager.addStatsItem(1, "Jacks Or Better");
		hr = new JacksOrBetterRecognizer();
		StatsManager.addTrackedRecognizer(hr, 1);
		recognizers.add(hr);
	}

	/**
	 * to start playing
	 */
	public void run() {
		PlayerAction action;
		do {
			action = this.player.getAction(this.hand);
			if (null != action) {
				action.doAction(this);
			}
		} while (null != action);
	}

	/**
	 * Check the hand of the player and determine if he wins or not, change his
	 * balance and call the deck.shuffle()
	 */
	public void afterRoundProcessing() {
		for (HandRecognizer handRecognizer : recognizers) {
			if (handRecognizer.recognizeHand(this.hand).isResult()) {
				StatsManager.increaseOccurrences(handRecognizer);
				if (ongoingBetAmount == 5) {
					int amount = handRecognizer.getFullPayReward();
					sumOfGains += amount;
					this.player.creditReward(amount);
				} else {
					int amount = handRecognizer.getRewardMultiplier() * ongoingBetAmount;
					sumOfGains += amount;
					this.player.creditReward(amount);
				}
				if(stream!=null)
				{
					stream.println("Player Wins with " + handRecognizer.getHandName() + " and his credit is: "
							+ this.player.getBalance());
				}
				this.deck.shuffle();
				return;
			}
		}
		this.deck.shuffle();
		if(stream!=null)
		{
			stream.println("Player Loses and his credit is: " + this.player.getBalance());
		}
	}
}