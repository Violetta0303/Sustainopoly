package sustainopoly;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


/**
 *  Get pictures
 */
public class GameUtil implements Serializable {
    public static Image getImage(String path) {
       BufferedImage img = null;

        try{
            img = ImageIO.read(new File(path));
        } catch(IOException e){
            e.printStackTrace();
        }

         return img;
    }
}
