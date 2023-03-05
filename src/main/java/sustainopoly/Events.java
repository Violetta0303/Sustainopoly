package playersInformation;

import sustainopoly.Player;
import sustainopoly.VoiceAnnouncementsUtil;

import javax.swing.*;
import java.util.Random;

/**
 * Events
 */

public class Events {
    VoiceAnnouncementsUtil voice;

    /**
     * Start(Add Effort)
     */
    public void start(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome back! You can add 10 points effort!");
        voice.strat("Welcome back! You can add ten points effort!");
        p.effort += 10;
    }

    /**
     * Fate
     */
    public void fate(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome to 'FATE'!");
        voice.strat("Welcome to 'FATE'!");
        Random rand1 = new Random();
        int r1 = rand1.nextInt(10) + 1;
        Random rand2 = new Random();
        int r2 = rand2.nextInt(2);

        if (r2 == 1) {
            p.effort *= (1 + r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Congratulations! You get " + r1 + "% effort!");
            voice.strat("Congratulations! You get " + r1 + "percent strength!");
        } else if (r2 == 0) {
            p.effort *= (1 - r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Unfortunate! You lose " + r1 + "% effort!");
            voice.strat("Unfortunate! You lose " + r1 + "percent strength!");
        }
    }

    /**
     * Store
     */
    public void store(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome to 'Store'!");
        voice.strat("Welcome to 'Store'!");


        String[] options1 = {"Choose the character you want to exchange", "Effort", "Leadership", "Programming Skills"};
        ImageIcon icon1 = new ImageIcon("src/main/java/images/Icon/Store.png");
        String n1 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon1, options1, options1[2]);
        System.out.println(n1);
        voice.strat("Choose the character you want to exchange");


        String[] options2 = {"Choose the points you want to exchange", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ImageIcon icon2 = new ImageIcon("src/main/java/images/Icon/Store.png");
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

        if (n1 == "Effort") {
            p.effort -= a;
            p.leadership += a;
            voice.strat("Successful!");
            JOptionPane.showMessageDialog(null, "Successful!");
        } else if (n1 == "Leadership") {
            p.leadership -= a;
            p.effort += a;
            voice.strat("Successful!");
            JOptionPane.showMessageDialog(null, "Successful!");
        }
    }

    /**
     * Mental Health Centre
     */
    public void mentalhealthcentre(Player p) {
        int flag = 1;

        JOptionPane.showMessageDialog(null, "Welcome to 'Mental Health Centre'!");
        voice.strat("Welcome to 'Mental Health Centre'!");

        String[] options = {"Could you please help us to improve residents' mental health?", "Yes", "No"};
        ImageIcon icon = new ImageIcon("src/main/java/images/Icon/Mental Health Centre.png");
        String n = (String) JOptionPane.showInputDialog(null, "Task",
                "Mental Health Centre", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
        System.out.println(n);
        voice.strat("Could you please have me to improve residents' mental health?");

        if (n == "Yes") {
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Let's start! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.");
                voice.strat("Let's get started! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.");
                p.effort -= 20;
                p.leadership += 5;
                p.program += 10;
                p.exp += 5;
                JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 program skills and 5 experience");
                voice.strat("You lose twenty effort, but gain five leadership, ten program skills and five experience");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 2;
            }else if(flag == 2){
                JOptionPane.showMessageDialog(null,"Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.");
                voice.strat("Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.");
                p.effort -= 10;
                p.leadership += 2;
                p.program += 5;
                p.exp += 2;
                JOptionPane.showMessageDialog(null,"You lose 10 effort, but gain 2 leadership, 5 program skills and 2 experience.");
                voice.strat("You lose ten effort, but gain two leadership, five program skills and two experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 3;
            }else if(flag == 3){
                JOptionPane.showMessageDialog(null,"Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.");
                voice.strat("Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.");
                p.effort -= 5;
                p.exp +=2;
                JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 experience.");
                voice.strat("You lose five effort, but gain two experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 4;
            }
        } else if (n == "No") {
            JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.");
            voice.strat("Oh...You are such a cold person.");
        }
    }

    /**
     * Food Bank
     */
    public void foodbank(Player p) {
        int flag = 1;

        JOptionPane.showMessageDialog(null, "Welcome to 'Food Bank'!");
        voice.strat("Welcome to 'Food Bank'!");

        String[] options = {"Could you please help us to improve food bank?", "Yes", "No"};
        ImageIcon icon = new ImageIcon("src/main/java/images/Icon/Food Bank.png");
        String n = (String) JOptionPane.showInputDialog(null, "Food Bank",
                "Food Bank", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
        System.out.println(n);
        voice.strat("Could you please help us to improve food bank?");

        if (n == "Yes") {
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Let's start! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.");
                voice.strat("Let's get started! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.");
                p.effort -= 10;
                p.leadership += 5;
                p.exp += 5;
                JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership and 5 experience");
                voice.strat("You lose ten effort, but gain five leadership and five experience");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 2;
            }else if(flag == 2){
                JOptionPane.showMessageDialog(null,"Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.");
                voice.strat("Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.");
                p.effort -= 10;
                p.leadership += 5;
                p.exp += 5;
                JOptionPane.showMessageDialog(null,"You lose 10 effort, but gain 5 leadership and 5 experience.");
                voice.strat("You lose ten effort, but gain two leadership and five experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 3;
            }else if(flag == 3){
                JOptionPane.showMessageDialog(null,"Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.");
                voice.strat("Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.");
                p.effort -= 20;
                p.leadership +=5;
                p.program += 10;
                p.exp +=5;
                JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 programming skills and 5 experience.");
                voice.strat("You lose twenty effort, but gain five leadership, ten programming skills and five experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 4;
            }else if(flag == 4){
                JOptionPane.showMessageDialog(null,"Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.");
                voice.strat("Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.");
                p.effort -= 10;
                p.leadership +=3;
                p.program += 5;
                p.exp +=3;
                JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 3 leadership, 5 programming skills and 3 experience.");
                voice.strat("You lose ten effort, but gain three leadership, five programming skills and three experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 5;
            }
        } else if (n == "No") {
            JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.");
            voice.strat("Oh...You are such a cold person.");
        }
    }

    /**
     * Mosque
     */
    public void mosque(Player p) {
        int flag = 1;

        JOptionPane.showMessageDialog(null, "Welcome to ''!");
        voice.strat("Welcome to ''!");

        String[] options = {"Could you please help us to improve ?", "Yes", "No"};
        ImageIcon icon = new ImageIcon("src/main/java/images/Icon/.png");
        String n = (String) JOptionPane.showInputDialog(null, "",
                "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
        System.out.println(n);
        voice.strat("Could you please have me to improve ?");

        if (n == "Yes") {
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Let's start!");
                voice.strat("Let's get started!");
                p.effort -= ;
                p.leadership += ;
                p.program += ;
                p.exp += ;
                JOptionPane.showMessageDialog(null, "You lose  effort, but gain  leadership,  program skills and  experience");
                voice.strat("You lose  effort, but gain  leadership,  program skills and  experience");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 2;
            }else if(flag == 2){
                JOptionPane.showMessageDialog(null,"Let's start!");
                voice.strat("Let's start!");
                p.effort -= ;
                p.leadership += ;
                p.program += ;
                p.exp += ;
                JOptionPane.showMessageDialog(null,"You lose  effort, but gain  leadership,  program skills and  experience.");
                voice.strat("You lose  effort, but gain  leadership,  program skills and  experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 3;
            }else if(flag == 3){
                JOptionPane.showMessageDialog(null,"Let's start!");
                voice.strat("Let's start!");
                p.effort -= ;
                p.exp += ;
                JOptionPane.showMessageDialog(null, "You lose  effort, but gain  experience.");
                voice.strat("You lose  effort, but gain  experience.");
                JOptionPane.showMessageDialog(null,"Thank you for your contribution to Govan!");
                voice.strat("Thank you for your contribution to Govan!");
                flag = 4;
            }
        } else if (n == "No") {
            JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.");
            voice.strat("Oh...You are such a cold person.");
        }
    }
}
