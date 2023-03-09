package sustainopoly;

import java.applet.AudioClip;

import javax.swing.*;

public class PlayMusicUtil extends Thread {
    AudioClip player;
    String music;

    public PlayMusicUtil(String music) {
        this.music = music;
    }

    public static void play(String music) {
        try {
            JApplet.newAudioClip(PlayMusicUtil.class.getResource(music)).play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        this.player = JApplet.newAudioClip(this.getClass().getResource(this.music));
        this.player.loop();
    }

    public void close() {
        this.player.stop();
        this.interrupt();
    }

    @Override
    public void run() {
        super.run();
        this.play();
    }
}