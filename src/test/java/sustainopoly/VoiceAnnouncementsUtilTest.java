package sustainopoly;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: VoiceAnnouncementsUtilTest
 * @Description:
 * @Author: qinhq
 * @Date: 2023-03-19 16:01:16
 */
public class VoiceAnnouncementsUtilTest {

    @Test
    public void testStart() {
        VoiceAnnouncementsUtil.strat("");
        assertNotEquals(null, VoiceAnnouncementsUtil.sap.getProperty("Volume"));
    }
}
