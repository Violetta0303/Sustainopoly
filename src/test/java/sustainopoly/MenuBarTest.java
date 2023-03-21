package sustainopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static sustainopoly.StartGame.gamePanel;

/**
 * @ClassName: MenuBarTest
 * @Description:
 * @Author:
 * @Date: 2023-03-19 14:05:07
 */
public class MenuBarTest {

    @Test
    public void testShowDialog() {
        MenuBar menuBar = new MenuBar();
        assertEquals(0, menuBar.showDialog("message", "<!DOCTYPE><html lang='en'><head><meta charset='utf-8'><style>.blue{color:blue}</style></head><body><span>Resource: <span class='blue'>https://www.ewb-uk.org/</body></html>"));
    }

    @Test
    public void testOnVoiceAnnouceChange() {
        MenuBar menuBar = new MenuBar();
        menuBar.onVoiceAnnouceChange();
        assertEquals(false, gamePanel.data.isVoiceAnnounce);
    }
}
