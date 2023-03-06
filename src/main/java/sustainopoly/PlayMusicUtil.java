package sustainopoly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayMusicUtil extends Thread {
        @Override
        public void run() {
            File file=new File("src/main/java/music/BGM.mp3");
            FileInputStream stream= null;
            try {
                stream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            javazoom.jl.player.Player player= null;
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
}