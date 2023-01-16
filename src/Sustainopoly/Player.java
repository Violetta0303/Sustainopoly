package Sustainopoly;

import java.awt.*;

public class Player extends GameObject{

    /**
     * ID
     */
    public int id;

    /**
     * strength
     */
    public int strength = 100;

    /**
     * leadership
     */
    public int leadership = 100;

    /**
     * experience
     */
    public int exp = 0;

    @Override
    public void drawMyself(Graphics g) {
            super.drawMyself(g);
    }


    /**
     * @param img is the Player's image
     * @param x is the x position of the Player
     * @param y is the y position of the Player
     * @param width is the width of the picture of the Player
     * @param height is the height of the picture of the Player
     */
    public Player(Image img, int x, int y, int width, int height, int minpy, int maxpy) {
        super(img, x, y, width, height, minpy, maxpy);
    }

}
