package src.java.poker.app.stats;

import java.util.HashMap;
import java.util.Map;


import src.java.poker.app.hand.recognition.HandRecognizer;

public class StatsManager {
    private static Map<Integer, StatsItem> itemsMap = new HashMap<>();
    private static Map<HandRecognizer, Integer> recognizersMap = new HashMap<>();
    private StatsManager() {
    }

    public static void addStatsItem(Integer id, String name)
    {
        itemsMap.put(id, new StatsItem(name));
    }

    public static void addTrackedRecognizer(HandRecognizer handRecognizer, Integer id)
    {
        recognizersMap.put(handRecognizer, id);
    }
    public static void increaseOccurrences(HandRecognizer handRecognizer)
    {
        Integer key = recognizersMap.get(handRecognizer);
        itemsMap.get(key).increaseOccurrences();
    }

    public static StatsItem getStatsItemByID(Integer id)
    {
        return itemsMap.get(id);
    }
}
