package sustainopoly;

import org.junit.jupiter.api.Test;
import sustainopoly.EndGamePanelUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: EndGamePanelUtilTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 20:41:38
 */
public class EndGamePanelUtilTest {

    @Test
    public void testInit() {
        EndGamePanelUtil.init();
        assertEquals("GAME OVER", EndGamePanelUtil.endFrame.getTitle());
        assertEquals(800, EndGamePanelUtil.endFrame.getBounds().height);
        assertEquals(true, EndGamePanelUtil.endFrame.isVisible());
        assertEquals(false, EndGamePanelUtil.endFrame.isResizable());
    }
}
