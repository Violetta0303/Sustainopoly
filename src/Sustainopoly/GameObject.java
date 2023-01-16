package Sustainopoly;

import java.awt.*;

/**
 * Game Object
 * set images' position
 */
public class GameObject {

    Image img; //picture
    int x,y; //position

    int width,height; //object's width & height

    int minpy,maxpy;

    public GameObject(Image img, int x, int y, int width, int height, int minpy, int maxpy) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.minpy = minpy;
        this.maxpy = maxpy;
    }


    public void drawMyself(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }

}
