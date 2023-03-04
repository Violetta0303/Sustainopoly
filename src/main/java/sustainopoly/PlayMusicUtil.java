package game;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMusicUtil {
    public static void main(String[] args) throws Exception {
        File file=new File("src/main/java/music/Snowman.mp3");
        FileInputStream stream=new FileInputStream(file);
        Player player=new Player(stream);
        player.play();
    }
}