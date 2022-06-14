package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.card.Suit;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;

public class SimPlayerTests {
    @Test
    public void SimPlayerHardHandTest()
    {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("KC QC JC TC 9C"));
        Integer[] indexes = {0,1,2,3,4};
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
        app.setHand(new Hand("AH AD AS 2C 2S"));
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
        app.setHand(new Hand("4C 4S 4H 5D 5C"));
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }
}
