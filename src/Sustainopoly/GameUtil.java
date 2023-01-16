package Sustainopoly;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


/**
 *  Get pictures
 */
public class GameUtil {
    public static Image getImage(String path) {   // ;
       BufferedImage img = null;
        URL u =  GameUtil.class.getClassLoader().getResource(path);  //会返回一个 URL 对象

        try{
            img = ImageIO.read(u);  // 这里会报错
        } catch(IOException e){
            e.printStackTrace();
        }

         return img;
    }

    public static void main(String[] args) {
       Image img = GameUtil.getImage("images/Dicebutton.jpg");
        System.out.println(img);
    }
}
