package sustainopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: StartGameTest
 * @Description:
 * @Author:
 * @Date: 2023-03-16 22:54:01
 */
public class StartGameTest {

    @Test
    public void testInit() {
        StartGame startGame = new StartGame();
        startGame.init();
        assertEquals(810, StartGame.frame.getBounds().height);
    }
}
