package game;

import javax.swing.*;
import java.util.Random;

/**
 * Events
 */

public class Events {
    VoiceAnnouncementsUtil voice;

    /**
     * Start(Add Strength)
     */
    public void start(Player p) {
        JOptionPane.showMessageDialog(null,"Welcome back! You can add 10 points strength!");
        voice.strat("Welcome back! You can add 10 points strength!");
        p.strength += 10;
    }

    /**
     * Fate
     */
    public void fate(Player p) {
        JOptionPane.showMessageDialog(null,"Welcome to 'FATE'!");
        voice.strat("Welcome to 'FATE'!");
        Random rand1 = new Random();
        int r1 = rand1.nextInt(10) + 1;
        Random rand2 = new Random();
        int r2 = rand2.nextInt(2);

        if(r2 == 1){
            p.strength *= (1 + r1*0.01);
            JOptionPane.showMessageDialog(null,"Congratulations! You get " + r1 + "% strength!");
            voice.strat("Congratulations! You get " + r1 + "% strength!");
        }else if(r2 == 0){
            p.strength *= (1 - r1*0.01);
            JOptionPane.showMessageDialog(null,"Unfortunate! You lose " + r1 + "% strength!");
            voice.strat("Unfortunate! You lose " + r1 + "% strength!");
        }
    }

    /**
     * Store
     */
    public void exchange(Player p) {
        JOptionPane.showMessageDialog(null,"Welcome to 'Store'!");
        voice.strat("Welcome to 'Store'!");


        String[] options1 = {"Choose the character you want to exchange", "strength", "leadership"};
        ImageIcon icon1 = new ImageIcon("src/main/java/images/Store.png");
        String n1 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon1, options1, options1[2]);
        System.out.println(n1);
        voice.strat("Choose the character you want to exchange");


        String[] options2 = {"Choose the points you want to exchange", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ImageIcon icon2 = new ImageIcon("src/main/java/images/Store.png");
        String n2 = (String) JOptionPane.showInputDialog(null, "Choose the points",
                "Store", JOptionPane.QUESTION_MESSAGE, icon2, options2, options2[2]);
        System.out.println(n2);
        voice.strat("Choose the  points you want to exchange");

        int a = Integer.parseInt(n2);

        try {
            a = Integer.valueOf(n2).intValue();

        } catch (NumberFormatException e) {

            e.printStackTrace();
        }

        if (n1 == "strength") {
            p.strength -= a;
            p.leadership += a;
            voice.strat("Successful!");
            JOptionPane.showMessageDialog(null,"Successful!");
        }else if(n1 == "leadership"){
            p.leadership -= a;
            p.strength += a;
            voice.strat("Successful!");
            JOptionPane.showMessageDialog(null,"Successful!");
        }
    }

    /**
     * Task
     */
    public void task(Player p) {
        JOptionPane.showMessageDialog(null,"Welcome to 'task'!");
        voice.strat("Welcome to 'task'!");

        String[] options = {"Accept the task or not", "Yes", "No"};
        ImageIcon icon = new ImageIcon("src/main/java/images/KinningPark.png");
        String n = (String)JOptionPane.showInputDialog(null, "Task",
                "Kinning Park", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
        System.out.println(n);
        voice.strat("Accept the task or not");

        if(n == "Yes"){
            JOptionPane.showMessageDialog(null,"In order to develop the Industry in Govan, You need to recruit technical staff.");
            voice.strat("In order to develop the Industry in Govan, You need to recruit technical staff.");

            p.strength -= 5;
            p.leadership -= 5;
            p.exp += 5;
            JOptionPane.showMessageDialog(null,"You lose 5 strength, 5 leadership and gain 5 experience");
            voice.strat("You lose 5 strength, 5 leadership and gain 5 experience");
        }else if(n == "No") {
            JOptionPane.showMessageDialog(null, "You miss the chance to improve Govan T_T");
            voice.strat("You miss the chance to improve Govan T_T");
        }
    }

}
