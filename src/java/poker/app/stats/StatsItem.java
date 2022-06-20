package src.java.poker.app.stats;

/**
 * 
 * To handle statistical items
 *
 */
public class StatsItem {
	private final String name;
	private Integer occurrences;

	/**
	 * getter of Occurrences
	 * 
	 * @return occurrences
	 */
	public Integer getOccurrences() {
		return occurrences;
	}

	/**
	 * public constructor
	 * 
	 * @param name the given name of the statistical item
	 */
	public StatsItem(String name) {
		this.name = name;
		this.occurrences = 0;
	}

	/**
	 * Increase occurrences by one
	 */

	public void increaseOccurrences() {
		this.occurrences++;
	}

	/**
	 * @return string
	 */
	@Override
	public String toString() {
		return name + " " + occurrences;
	}
}
