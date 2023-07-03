package sustainopoly;

import java.applet.AudioClip;

import javazoom.jl.decoder.JavaLayerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.*;

public class PlayMusicUtil extends Thread {
    String music;

    static javazoom.jl.player.Player player;

    static FileInputStream stream = null;

    public PlayMusicUtil(String music) {
        this.music = music;
    }

    public static void play(String music) {
        File file = new File(music);
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        javazoom.jl.player.Player player = null;
        try {
            player = new javazoom.jl.player.Player(stream);
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
        try {
            player.play();
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        File file = new File(music);
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            player = new javazoom.jl.player.Player(stream);
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
        try {
            while (player != null) {
                player.play();
            }
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        if (player != null)
            player.close();
    }

    @Override
    public void run() {
        super.run();
        this.play();
    }
}