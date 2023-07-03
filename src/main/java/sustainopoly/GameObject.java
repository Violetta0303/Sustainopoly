package sustainopoly;

import java.awt.*;
import java.io.Serializable;

/**
 * Game Object
 * set images' position
 */
public class GameObject implements Serializable {

    Image img; //picture
    int x,y; //position

    int width,height; //object's width & height

    int minpy,maxpy;
    int minpx,maxpx;

    public GameObject(Image img, int x, int y, int width, int height, int minpy, int maxpy, int minpx, int maxpx) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.minpy = minpy;
        this.maxpy = maxpy;
        this.minpx = minpx;
        this.maxpx = maxpx;
    }

    public void drawMyself(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
}
