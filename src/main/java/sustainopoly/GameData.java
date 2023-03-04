package game;

import javax.swing.*;
import java.awt.*;

/**
 * Game Data
 * import images
 */
public class GameData {
    // Background image
    public static Image bc = GameUtil.getImage("src/main/java/images/Background.png");

    // Player images
    public static Image play1 = GameUtil.getImage(("src/main/java/images/Player/P1.png"));
    public static Image play2 = GameUtil.getImage(("src/main/java/images/Player/P2.png"));

    // Button image
    public static Image dc = GameUtil.getImage("src/main/java/images/Dicebutton.jpg");
    public static ImageIcon dicemodel = new ImageIcon(dc);

    //Dice image
    public static Image dc0 = GameUtil.getImage("src/main/java/images/DICES.GIF");
    public static ImageIcon DC0 = new ImageIcon(dc0);


    //1-6 Dice images
    public static Image dc1 = GameUtil.getImage("src/main/java/images/Dices/1.png");
    public static ImageIcon DC1 = new ImageIcon(dc1);

    public static Image dc2 = GameUtil.getImage("src/main/java/images/Dices/2.png");
    public static ImageIcon DC2 = new ImageIcon(dc2);
    public static Image dc3 = GameUtil.getImage("src/main/java/images/Dices/3.png");
    public static ImageIcon DC3 = new ImageIcon(dc3);
    public static Image dc4 = GameUtil.getImage("src/main/java/images/Dices/4.png");
    public static ImageIcon DC4 = new ImageIcon(dc4);
    public static Image dc5 = GameUtil.getImage("src/main/java/images/Dices/5.png");
    public static ImageIcon DC5 = new ImageIcon(dc5);
    public static Image dc6 = GameUtil.getImage("src/main/java/images/Dices/6.png");
    public static ImageIcon DC6 = new ImageIcon(dc6);


}
