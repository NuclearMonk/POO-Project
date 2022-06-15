package src.test.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import src.java.poker.app.App;
import src.java.poker.app.hand.Hand;
import src.java.poker.app.hand.recognition.ThreeAces;
import src.java.poker.player.Player;
import src.java.poker.player.SimulationPlayer;
import src.java.poker.player.actions.HoldCardsAction;

public class SimPlayerTests {
    @Test
    public void One() {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("KC QC JC TC 9C"));
        Integer[] indexes = { 0, 1, 2, 3, 4 };
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }

    @Test
    public void Two() {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("AD KD QS JD TD"));
        Integer[] indexes = { 0, 1, 3, 4 };
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }

    @Test
    public void Three()
    {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("AS KS JS TS 9S"));
        Integer[] indexes = {0,1,2,3};
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }

    @Test
    public void Four()
    {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("AH AD AS 2C 2S"));
        assertEquals(true, new ThreeAces().recognizeHand(app.getHand()).isResult());
        Integer[] indexes = {0,1,2};
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }

    @Test
    public void Five()
    {
        Player player = new SimulationPlayer(0);
        App app = new App(player, null);
        app.setHand(new Hand("4C 4S 4H 5D 5C"));
        Integer[] indexes = {0,1,2,3,4};
        assertEquals(new HoldCardsAction(Arrays.asList(indexes)), app.getPlayer().getAction(app.getHand()));
    }
}
