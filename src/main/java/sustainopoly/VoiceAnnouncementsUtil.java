package sustainopoly;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * Voice Announcements Util
 */
public class VoiceAnnouncementsUtil {

    public static void strat(String str) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try {
            // Volume 0 - 100
            sap.setProperty("Volume", new Variant(100));
            // Rate -10 to +10
            sap.setProperty("Rate", new Variant(2));
            // Speak
            Dispatch.call(sapo, "Speak", new Variant(str));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }

}
