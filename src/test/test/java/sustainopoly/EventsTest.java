package sustainopoly;

import org.junit.jupiter.api.Test;
import sustainopoly.Events;
import sustainopoly.GameData;
import sustainopoly.Player;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: EventsTest
 * @Description:
 * @Author:
 * @Date: 2023-03-15 13:38:44
 */
public class EventsTest {

    @Test
    public void testStart() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        events.start(player);
        assertEquals(110, player.effort);
    }

    @Test
    public void testFate() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        events.fate(player);
        assertNotEquals(110, player.effort);
    }

    @Test
    public void testStore() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int p = player.program;
        events.store(player);
        assertNotEquals(p, player.program);
    }

    @Test
    public void testMentalhealthcentre1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.mentalhealthcentre1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testMentalhealthcentre2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.mentalhealthcentre2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testFoodbank1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.foodbank1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testFoodbank2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.foodbank2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testMosque() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.mosque(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testMarket1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.market1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testMarket2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.market2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testSocialmedia() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.socialmedia(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testRadio1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.Radio1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testRadio2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.Radio2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testActivitycentre1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.activitycentre1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testActivitycentre2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.activitycentre2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testTakechargeof1() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.takechargeof1(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testTakechargeof2() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.takechargeof2(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testTakechargeof3() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.takechargeof3(player);
        assertNotEquals(e, player.effort);
    }

    @Test
    public void testTakechargeof4() {
        Player player = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
        Events events = new Events();
        int e = player.effort;
        events.takechargeof4(player);
        assertNotEquals(e, player.effort);
    }
}
