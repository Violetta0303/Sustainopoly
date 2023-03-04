package game;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * Start a thread for dice pictures
 */
public class IconThread extends Observable implements Runnable {
    JLabel lab;
    Random random = new Random();
    List<Icon> photo;

    public IconThread(JLabel lab, List<Icon> photo) {
        this.lab = lab;
        this.photo = photo;
    }

    /**
     * Loop Dice pictures, and random number of Dice
     */
    @Override
    public void run() {
        int count = 20;
        while (count > 0) {
            int Point = random.nextInt(6); // [0,6)
            lab.setIcon(photo.get(Point));
            count--;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Calculate the sum of two dice
     * @param JL is the JLabel of the Dice
     * @return
     */
    public int playerResult(JLabel JL){
        Icon icon = JL.getIcon();
        int playersum = 0;
        for(int i=0;i<photo.size();i++){
            if(icon.equals(photo.get(i))){
                playersum=+(i+1);
                break;
            }
        }
        return  playersum;
    }

}
