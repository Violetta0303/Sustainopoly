package sustainopoly;

import org.junit.jupiter.api.Test;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: IconThreadTest
 * @Description:
 * @Author: qinhq
 * @Date: 2023-03-19 10:32:46
 */
public class IconThreadTest {

    @Test
    public void testPlayerResult() {
        JLabel jLabel = new JLabel();
        List<Icon> photo = new ArrayList<Icon>();
        photo.add(GameData.DC1);
        photo.add(GameData.DC1);
        photo.add(GameData.DC1);
        photo.add(GameData.DC1);
        photo.add(GameData.DC1);
        photo.add(GameData.DC1);
        IconThread iconThread = new IconThread(jLabel, photo);
        iconThread.run();
        assertNotEquals(null, iconThread.lab.getIcon());
        assertEquals(1, iconThread.playerResult(jLabel));
    }
}
