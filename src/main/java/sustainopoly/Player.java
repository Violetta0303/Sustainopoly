package sustainopoly;

import java.awt.*;

public class Player extends GameObject {

    /**
     * ID
     */
    public int id;

//    /**
//     * Avatar
//     */
//    public int avatar;

    /**
     * Effort
     */
    public int effort = 50;

    /**
     * Leadership
     */
    public int leadership = 20;

    /**
     * Programming Skills
     */
    public int program = 20;

    /**
     * Experience
     */
    public int exp = 0;

//    /**
//     * Score
//     */
//    public int score = leadership + program + exp;


    @Override
    public void drawMyself(Graphics g) {
        super.drawMyself(g);
    }


    /**
     * @param img    is the Player's image
     * @param x      is the x position of the Player
     * @param y      is the y position of the Player
     * @param width  is the width of the picture of the Player
     * @param height is the height of the picture of the Player
     */
    public Player(Image img, int x, int y, int width, int height, int minpy, int maxpy, int minpx, int maxpx) {
        super(img, x, y, width, height, minpy, maxpy, minpx, maxpx);
    }
}
