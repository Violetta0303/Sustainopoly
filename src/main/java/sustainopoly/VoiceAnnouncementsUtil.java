package sustainopoly;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * Voice Announcements Util
 */
public class VoiceAnnouncementsUtil extends Thread{
    static int volume = 100;
    static int rate = 2;

    public static void strat(String str) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try {
            // Volume 0 - 100
            sap.setProperty("Volume", new Variant(volume));
            // Rate -10 to +10
            sap.setProperty("Rate", new Variant(rate));
            // Speak
            Dispatch.call(sapo, "Speak", new Variant(str));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }

    public void close(){
        this.interrupt();
    }
}
