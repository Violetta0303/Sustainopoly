package sustainopoly;

import playersInformation.FrameConfig;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Game Data
 * import images
 */
public class GameData implements Serializable {
    //Background Music
    public boolean isMusic = false;

    //Voice Announcement
    public boolean isVoiceAnnounce = false;

    public boolean isPause = false;

    public boolean isRestart = false;

    public static Events event = new Events();

    public String backgroundMusicUrl = "src/main/java/music/BGM.mp3";

    public String throwdiceMusicUrl = "src/main/java/music/ThrowDice.mp3";

    // Background image
    public static Image bg = GameUtil.getImage("src/main/java/images/Map.png");

    // Player images
    public static Image play1 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[0]+1)+".jpg");
    public static Image play2 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[1]+1)+".jpg");
    public static Image play3 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[2]+1)+".jpg");
    public static Image play4 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[3]+1)+".jpg");
    public static Image play5 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[4]+1)+".jpg");
    public static Image play6 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[5]+1)+".jpg");
    public static Image play7 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[6]+1)+".jpg");
    public static Image play8 = GameUtil.getImage("src/main/java/images/Player/"+(FrameConfig.selected[7]+1)+".jpg");

    //Player
    public static Player Player1 = new Player(GameData.play1,1030,543,25,25,138,543,220,1030);
    public static Player Player2 = new Player(GameData.play2,1048,558,25,25, 153, 558,238,1048);
    public static Player Player3 = new Player(GameData.play3,1065,543,25,25, 138, 543,255,1070);
    public static Player Player4 = new Player(GameData.play4,1085,558,25,25, 153, 558,275,1085);
    public static Player Player5 = new Player(GameData.play5,1030,578,25,25, 173, 578,220,1030);
    public static Player Player6 = new Player(GameData.play6,1048,593,25,25, 188, 593,238,1048);
    public static Player Player7 = new Player(GameData.play7,1070,578,25,25, 173, 578,255,1070);
    public static Player Player8 = new Player(GameData.play8,1085,593,25,25, 188, 593,275,1085);

    // Button image
    public static Image dc = GameUtil.getImage("src/main/java/images/Dice/DiceButton.png");
    public static ImageIcon dicemodel = new ImageIcon(dc);

    //Dice image
    public static Image dc0 = GameUtil.getImage("src/main/java/images/Dice/DICE.png");
    public static ImageIcon DC0 = new ImageIcon(dc0);


    //1-6 Dice images
    public static Image dc1 = GameUtil.getImage("src/main/java/images/Dice/1.png");
    public static ImageIcon DC1 = new ImageIcon(dc1);

    public static Image dc2 = GameUtil.getImage("src/main/java/images/Dice/2.png");
    public static ImageIcon DC2 = new ImageIcon(dc2);
    public static Image dc3 = GameUtil.getImage("src/main/java/images/Dice/3.png");
    public static ImageIcon DC3 = new ImageIcon(dc3);
    public static Image dc4 = GameUtil.getImage("src/main/java/images/Dice/4.png");
    public static ImageIcon DC4 = new ImageIcon(dc4);
    public static Image dc5 = GameUtil.getImage("src/main/java/images/Dice/5.png");
    public static ImageIcon DC5 = new ImageIcon(dc5);
    public static Image dc6 = GameUtil.getImage("src/main/java/images/Dice/6.png");
    public static ImageIcon DC6 = new ImageIcon(dc6);


}
