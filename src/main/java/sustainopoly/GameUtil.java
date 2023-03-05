package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 *  Get pictures
 */
public class GameUtil {
    public static Image getImage(String path) {
       BufferedImage img = null;

        try{
            img = ImageIO.read(new File(path));
        } catch(IOException e){
            e.printStackTrace();
        }

         return img;
    }

    public static void main(String[] args) {
       Image img = GameUtil.getImage("src/main/java/images/Dicebutton.jpg");
        System.out.println(img);
    }
}