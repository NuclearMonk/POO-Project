package src.java.poker.player.actions;

import src.java.poker.app.App;
import src.java.poker.app.stats.StatsItem;
import src.java.poker.app.stats.StatsManager;

public class StatsAction implements PlayerAction {

    /**
     *
     */
    private static final String LINE = "------------------------";

    @Override
    public void doAction(App app) {
        Integer totalCount = 0;
        System.out.println("Hand nb");
        System.out.println(LINE);
        for (int i = 1; i < 10; i++) {
            StatsItem statsItem = StatsManager.getStatsItemByID(i);
            totalCount+=statsItem.getOccurrences();
            System.out.println(statsItem);
        }
        System.out.println("Other " + (app.getHandCount()-totalCount));
        System.out.println(LINE);
        System.out.println("Total "+app.getHandCount());
        System.out.println(LINE);
        System.out.println("Credit " + app.getPlayer().getBalance()+ "(" +(app.getSumOfGains().floatValue()/app.getSumOfBets()) *100 + "%)");
        
    }

}
