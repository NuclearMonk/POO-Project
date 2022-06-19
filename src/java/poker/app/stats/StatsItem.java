package src.java.poker.app.stats;


public class StatsItem {
    private final String name;
    private Integer occurrences;
    public Integer getOccurrences() {
        return occurrences;
    }
    public StatsItem(String name) {
        this.name = name;
        this.occurrences = 0;
    }
    public void increaseOccurrences()
    {
        this.occurrences ++;
    }
    @Override
    public String toString() {
        return name + " " + occurrences;
    }
}
