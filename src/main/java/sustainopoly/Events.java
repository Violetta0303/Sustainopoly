package sustainopoly;

import web.OpenWebPage;

import javax.swing.*;
import java.util.Random;

import static sustainopoly.MenuBar.voiceAnnouncementsUtil;

/**
 * Events
 */

public class Events {
    int flag_MentalHealthCentre1 = 1;
    int flag_MentalHealthCentre2 = 1;
    int flag_ActivityCentre1 = 1;
    int flag_ActivityCentre2 = 1;
    int flag_FoodBank1 = 1;
    int flag_FoodBank2 = 1;
    int flag_Market1 = 1;
    int flag_Market2 = 1;
    int flag_SocialMedia = 1;
    int flag_Radio1 = 1;
    int flag_Radio2 = 1;
    int flag_Mosque = 1;

    Player owner1 = null;
    Player owner2 = null;
    Player owner3 = null;
    Player owner4 = null;

    // Coco's pictures
    ImageIcon icon1 = new ImageIcon("src/main/java/images/Coco/Coco.png");
    ImageIcon icon2 = new ImageIcon("src/main/java/images/Coco/Plz.png");
    ImageIcon icon3 = new ImageIcon("src/main/java/images/Coco/Thinking.png");
    ImageIcon icon4 = new ImageIcon("src/main/java/images/Coco/Good.png");
    ImageIcon icon5 = new ImageIcon("src/main/java/images/Coco/Anger.png");

    /**
     * Start(Add Effort)
     */
    public void start(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome back! You can add 10 points effort, 5 points leadership, 5 points program and 5 points experience!");
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Welcome back! You can add ten points effort, five points leadership, five points program and five points experience!");
        p.effort += 10;
        p.leadership += 5;
        p.program += 5;
        p.exp += 5;
    }

    /**
     * Fate
     */
    public void fate(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome to 'FATE'!");
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Welcome to 'FATE'!");
        Random rand1 = new Random();
        int r1 = rand1.nextInt(10) + 1; //points
        Random rand2 = new Random();
        int r2 = rand2.nextInt(2); // fortunate or unfortunate
        String number[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        if (r2 == 1) {
            p.effort *= (1 + r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Congratulations! You get " + r1 + "% effort!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Congratulations! You get " + number[r1 - 1] + "percent effort!");
        } else if (r2 == 0) {
            p.effort *= (1 - r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Unfortunate! You lose " + r1 + "% effort!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Unfortunate! You lose " + number[r1 - 1] + "percent effort!");
        }
    }

    /**
     * Store
     */
    public void store(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome to 'Store'!");
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Welcome to 'Store'!");

        String[] options1 = {"Effort", "Leadership", "Programming Skills"};
        ImageIcon icon = new ImageIcon("src/main/java/images/Icon/Store.png");
        String n1 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options1, options1[2]);
        System.out.println(n1);
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Choose the character you want to exchange");

        String[] options2 = {"Effort", "Leadership", "Programming Skills"};
        String n2 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options2, options2[2]);
        System.out.println(n2);
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Choose the character you want to get");

        String[] options3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String n3 = (String) JOptionPane.showInputDialog(null, "Choose the points",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options3, options3[9]);
        System.out.println(n3);
        if (voiceAnnouncementsUtil != null)
            voiceAnnouncementsUtil.strat("Choose the  points you want to exchange");

        int a = Integer.parseInt(n3);

        if (n1 == "Effort") {
            p.effort -= a;
            if (n2.equals("Leadership")) {
                p.leadership += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2.equals("Programming Skills")) {
                p.program += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }
        } else if (n1.equals("Leadership")) {
            p.leadership -= a;
            if (n2.equals("Effort")) {
                p.effort += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2.equals("Programming Skills")) {
                p.program += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }
        } else if (n1.equals("Programming Skills")) {
            p.program -= a;
            if (n2.equals("Effort")) {
                p.effort += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2.equals("Leadership")) {
                p.leadership += a;
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }

        }
    }

    /**
     * Mental Health Centre1
     * Online(Website)
     */
    public void mentalhealthcentre1(Player p) {

        if (flag_MentalHealthCentre1 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Mental Health Centre'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Mental Health Centre'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to improve residents' mental health?",
                    "Mental Health Centre1", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please have me to improve residents' mental health?");

            if (n.equals("Yes")) {
                if (flag_MentalHealthCentre1 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.");
                    p.effort -= 20;
                    p.leadership += 5;
                    p.program += 10;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 program skills and 5 experience", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose twenty effort, but gain five leadership, ten program skills and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre1 = 2;
                } else if (flag_MentalHealthCentre1 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.");
                    p.effort -= 10;
                    p.leadership += 2;
                    p.program += 5;
                    p.exp += 2;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 2 leadership, 5 program skills and 2 experience.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain two leadership, five program skills and two experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre1 = 3;
                } else if (flag_MentalHealthCentre1 == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to provide a supportive community forum function on the website where users can share experiences and support each other.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to provide a supportive community forum function on the website where users can share experiences and support each other.");
                    p.effort -= 10;
                    p.leadership += 2;
                    p.program += 5;
                    p.exp += 2;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 2 leadership, 5 program skills and 2 experience.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain two leadership, five program skills and two experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre1 = 4;
                } else if (flag_MentalHealthCentre1 == 4) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to introduce scales to periodically provide users with a depression-based mental health assessment to help them understand their mental health status.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to introduce scales to periodically provide users with a depression-based mental health assessment to help them understand their mental health status.");
                    p.effort -= 7;
                    p.leadership += 2;
                    p.program += 3;
                    p.exp += 2;
                    JOptionPane.showMessageDialog(null, "You lose 7 effort,but gain 2 leadership, 3 program skills and 2 experience.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose seven effort,but gain two leadership, three program skills and two experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    //After finishing all the tasks in the Mental Health Centre1, open the Mental Health Web Page
                    JOptionPane.showMessageDialog(null, "Let's take a look at the Mental Health web page!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's take a look at the Mental Health web page!");
                    OpenWebPage.openMentalHealth();
                    flag_MentalHealthCentre1 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_MentalHealthCentre1 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Mental Health Centre1 have been done. Thanks for your help!", "Mental Health Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Mental Health Centre one have been done. Thanks for your help!");
        }
    }

    /**
     * Mental Health Centre2
     * Offline
     */
    public void mentalhealthcentre2(Player p) {

        if (flag_MentalHealthCentre2 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Mental Health Centre'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Mental Health Centre'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to improve residents' mental health?",
                    "Mental Health Centre2", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please have me to improve residents' mental health?");

            if (n.equals("Yes")) {
                if (flag_MentalHealthCentre2 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.");
                    p.effort -= 4;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 4 effort, but gain 3 experience.", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose four effort, but gain three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre2 = 2;
                } else if (flag_MentalHealthCentre2 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! In order to provide better protection for the mental health of our residents, we need to work with a nearby mental health agency to provide regular counselling services for our residents.", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! In order to provide better protection for the mental health of our residents, we need to work with a nearby mental health agency to provide regular counselling services for our residents.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership and 3 experience.", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose five effort, but gain two leadership and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre2 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Mental Health Centre2", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_MentalHealthCentre2 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Mental Health Centre2 have been done. Thanks for your help!", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Mental Health Centre two have been done. Thanks for your help!");
        }
    }

    /**
     * Food Bank1
     * Online(Website)
     */
    public void foodbank1(Player p) {

        if (flag_FoodBank1 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Food Bank'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Food Bank'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to improve food bank?",
                    "Food Bank1", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to improve food bank?");

            if (n.equals("Yes")) {
                if (flag_FoodBank1 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership and 5 experience", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank1 = 2;
                } else if (flag_FoodBank1 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership and 5 experience.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain two leadership and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank1 = 3;
                } else if (flag_FoodBank1 == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.");
                    p.effort -= 20;
                    p.leadership += 5;
                    p.program += 10;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 programming skills and 5 experience.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose 20 effort, but gain five leadership, ten programming skills and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank1 = 4;
                } else if (flag_FoodBank1 == 4) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.");
                    p.effort -= 10;
                    p.leadership += 3;
                    p.program += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 3 leadership, 5 programming skills and 3 experience.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain three leadership, five programming skills and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank1 = 0;

                    //After finishing all the tasks in the Food Bank, open the Food Bank Web Page
                    JOptionPane.showMessageDialog(null, "Let's take a look at the Food Bank web page!", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's take a look at the Food Bank web page!");
                    OpenWebPage.openFoodBank();
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_FoodBank1 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Food Bank1 have been done. Thanks for your help!", "Food Bank1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Food Bank one have been done. Thanks for your help!");
        }
    }

    /**
     * Food Bank2
     * Offline
     */
    public void foodbank2(Player p) {

        if (flag_FoodBank2 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Food Bank'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Food Bank'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to improve food bank?",
                    "Food Bank2", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to improve food bank?");

            if (n.equals("Yes")) {
                if (flag_FoodBank2 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! In order to make the Food Bank work better, we need to recruit volunteers for the Food Bank.", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! In order to make the Food Bank work better, we need to recruit volunteers for the Food Bank.");
                    p.effort -= 8;
                    p.leadership += 4;
                    p.exp += 4;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 4 leadership and 4 experience", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain four leadership and four experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank2 = 2;
                } else if (flag_FoodBank2 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! In order to better care for the disabled and elderly who have difficulty with their legs, volunteers are required to deliver food to their homes.", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! In order to better care for the disabled and elderly who have difficulty with their legs, volunteers are required to deliver food to their homes.");
                    p.effort -= 6;
                    p.leadership += 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 6 effort, but gain 3 leadership and 3 experience.", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose six effort, but gain three leadership and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank2 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_FoodBank2 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Food Bank2 have been done. Thanks for your help!", "Food Bank2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Food Bank two have been done. Thanks for your help!");
        }
    }

    /**
     * Mosque
     */
    public void mosque(Player p) {

        if (flag_Mosque != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Mosque'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Mosque'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to get Halal Food?",
                    "Mosque", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to get Halal Food?");

            if (n.equals("Yes")) {
                if (flag_Mosque == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to visit Mosque to understand the food needs of the Muslim population.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to visit Mosque to understand the food needs of the Muslim population.");
                    p.effort -= 8;
                    p.leadership += 4;
                    p.exp += 4;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 4 leadership, and 4 experience", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain four leadership, and four experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 2;
                } else if (flag_Mosque == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to communicate with both Food Bank and Mosque to establish cooperation between them.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to communicate with both Food Bank and Mosque to establish cooperation between them.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 3;
                } else if (flag_Mosque == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to get halal food to meet the basic food needs of the Muslim residents.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to get halal food to meet the basic food needs of the Muslim residents.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership and 3 experience.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose five effort, but gain two leadership and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_Mosque == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Mosque have been done. Thanks for your help!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Mosuqe have been done. Thanks for your help!");
        }
    }

    /**
     * Market1
     */
    public void market1(Player p) {

        if (flag_Market1 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Market'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Market'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to get more Food?",
                    "Market1", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to get more Food?");

            if (n.equals("Yes")) {
                if (flag_Market1 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to know the information on the Market's daily food surplus.", "Market1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to know the information on the Market's daily food surplus.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership, and 3 experience", "Market1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose five effort, but gain two leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Market1 = 2;
                } else if (flag_Market1 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to communicate with the Market management to get the Market to provide excess food to the Food Bank and build closer cooperation with the Food Bank.", "Market", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to communicate with the Market management to get the Market to provide excess food to the Food Bank and build closer cooperation with the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Market1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Market1 = 3;
                } else if (flag_Market1 == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to get the food from the Market and transport it to the Food Bank so that the inhabitants can have enough food in the Food Bank.", "Market", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to get the food from the Market and transport it to the Food Bank so that the inhabitants can have enough food in the Food Bank");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership, and 3 experience.", "Market1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose five effort, but gain two leadership, and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Market1 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market1", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_Market1 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Market have been done. Thanks for your help!", "Market1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Market one have been done. Thanks for your help!");
        }
    }

    /**
     * Market2
     */
    public void market2(Player p) {

        if (flag_Market2 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Market'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Market'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to get more household items?",
                    "Market2", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to get more household items?");

            if (n.equals("Yes")) {
                if (flag_Market2 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to know the latest information on the market for near-expired household goods at reduced prices.", "Market2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to know the latest information on the market for near-expired household goods at reduced prices.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership, and 3 experience", "Market2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose five effort, but gain two leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Market2 = 2;
                } else if (flag_Market2 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to collect and sort the information on the near-expired household items and make the list available to residents in real-time so that they can shop for them if they are struggling to make ends meet.", "Market2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to collect and sort the information on the near-expired household items and make the list available to residents in real-time so that they can shop for them if they are struggling to make ends meet.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Market2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Market2 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market2", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_Market2 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Market have been done. Thanks for your help!", "Market2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Market two have been done. Thanks for your help!");
        }
    }

    /**
     * Social Media
     */
    public void socialmedia(Player p) {
        if (flag_SocialMedia != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Social Media'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Social Media'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to promote and advertise on Social Media?",
                    "Social Media", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to promote and advertise on Social Media?");

            if (n.equals("Yes")) {
                if (flag_SocialMedia == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to use Social Media to promote Food issues and Mental health issues.", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to use Social Media to promote Food issues and Mental Health issues.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership, and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_SocialMedia = 2;
                } else if (flag_SocialMedia == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to attract more volunteers and donors, as well as raise public awareness of Food issues and Mental Health issues.", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to attract more volunteers and donors, as well as raise public awareness of Food issues and Mental Health issues.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_SocialMedia = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_SocialMedia == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Social Media have been done. Thanks for your help!", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Social Media have been done. Thanks for your help!");
        }
    }

    /**
     * Community Radio1
     */
    public void Radio1(Player p) {

        if (flag_Radio1 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Community Radio'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Community Radio'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us with the broadcast?",
                    "Community Radio1", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us with the broadcast?");

            if (n.equals("Yes")) {
                if (flag_Radio1 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast the Food Bank's real-time Food Information, helping residents who do not have easy access to the internet to get real-time Food Information.", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to broadcast the Food Bank's real-time Food Information, helping residents who do not have easy access to the internet to get real-time Food Information.");
                    p.effort -= 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 3 effort, but gain 3 experience", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose three effort, but gain three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Radio1 = 2;
                } else if (flag_Radio1 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast Mental Health knowledge to help residents improve their Mental Health.", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to broadcast Mental Health knowledge to help residents improve their Mental Health.");
                    p.effort -= 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 3 effort, but gain 3 experience.", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose three effort, but gain three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Radio1 = 0;
                } else if (n.equals("No")) {
                    JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon5);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
                }
            }
        } else if (flag_Radio1 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Community Radio have been done. Thanks for your help!", "Community Radio1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Community Radio one have been done. Thanks for your help!");
        }
    }

    /**
     * Community Radio2
     */
    public void Radio2(Player p) {

        if (flag_Radio2 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Community Radio'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Community Radio'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us with the broadcast?",
                    "Community Radio2", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us with the broadcast?");

            if (n.equals("Yes")) {
                if (flag_Radio2 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast news so that those who do not have easy access to the internet can also get the latest information from around the world.", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to broadcast news so that those who do not have easy access to the internet can also get the latest information from around the world.");
                    p.effort -= 4;
                    p.exp += 4;
                    JOptionPane.showMessageDialog(null, "You lose 4 effort, but gain 4 experience", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose four effort, but gain four experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!","Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Radio2 = 2;
                } else if (flag_Radio2 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast job vacancies in nearby companies so that people who need to find a job can easily access this information.", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to broadcast job vacancies in nearby companies so that people who need to find a job can easily access this information.");
                    p.effort -= 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 3 effort, but gain 3 experience.", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose three effort, but gain three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_Radio2 = 0;
                } else if (n.equals("No")) {
                    JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon5);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
                }
            }
        } else if (flag_Radio2 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Community Radio have been done. Thanks for your help!", "Community Radio2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Community Radio two have been done. Thanks for your help!");
        }
    }

    /**
     * Activity Centre1
     */
    public void activitycentre1(Player p) {

        if (flag_ActivityCentre1 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Activity Centre'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Activity Centre'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to organise activities?",
                    "Activity Centre1", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to organise activities?");

            if (n.equals("Yes")) {
                if (flag_ActivityCentre1 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to organise events, tea parties, etc. to strengthen the ties between residents and increase their sense of belonging to the community.", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to organise events, tea parties, etc. to strengthen the ties between residents and increase their sense of belonging to the community.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 3 leadership, and 5 experience", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain five leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre1 = 2;
                } else if (flag_ActivityCentre1 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to conduct science talks on Food, Mental Health and other topics to raise awareness of environmental and health issues among residents.", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to conduct science talks on Food, Mental Health and other topics to raise awareness of environmental and health issues among residents.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 5 leadership, and 3 experience.", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain five leadership, and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre1 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_ActivityCentre1 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Activity Centre have been done. Thanks for your help!", "Activity Centre1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Activity Centre one have been done. Thanks for your help!");
        }
    }

    /**
     * Activity Centre2
     */
    public void activitycentre2(Player p) {

        if (flag_ActivityCentre2 != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Activity Centre'!");
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Welcome to 'Activity Centre'!");

            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Could you please help us to organise activities?",
                    "Activity Centre2", JOptionPane.QUESTION_MESSAGE, icon2, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Could you please help us to organise activities?");

            if (n.equals("Yes")) {
                if (flag_ActivityCentre2 == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to organise a community sports day to give residents exercise.", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to organise a community sports day to give residents exercise.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 3 leadership, and 5 experience", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain five leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre1 = 2;
                } else if (flag_ActivityCentre2 == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to work with nearby universities to organise events where local students can visit and learn.", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon3);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Let's start! We need to work with nearby universities to organise events where local students can visit and learn.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 5 leadership, and 3 experience.", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon1);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("You lose eight effort, but gain five leadership, and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon4);
                    if (voiceAnnouncementsUtil != null)
                        voiceAnnouncementsUtil.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre2 = 0;
                }
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon5);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You are such a cold person.");
            }
        } else if (flag_ActivityCentre2 == 0) {
            JOptionPane.showMessageDialog(null, "All the tasks in Activity Centre have been done. Thanks for your help!", "Activity Centre2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("All the tasks in Activity Centre two have been done. Thanks for your help!");
        }
    }

    /**
     * House1
     */
    public void takechargeof1(Player p) {
        if (owner1 == null) {
            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Do you want to take charge of it?",
                    "House1", JOptionPane.QUESTION_MESSAGE, icon1, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Do you want to take charge of it?");
            if (n.equals("Yes")) {
                JOptionPane.showMessageDialog(null, "Nice choice. Now you are taking charge of it.", "House1", JOptionPane.INFORMATION_MESSAGE, icon4);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Nice choice. Now you are taking charge of it.");
                p.effort -= 25;
                p.leadership -= 15;
                p.own += "House1 ";
                JOptionPane.showMessageDialog(null, "You spend 25 effort and 15 leadership to take charge of it.", "House1", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("You spend twenty five effort and fifteen leadership to take charge of it.");
                owner1 = p;
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You miss the chance to take charge of it.", "House1", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You miss the chance to take charge of it.");
            }
        } else if (owner1 != null) {
            JOptionPane.showMessageDialog(null, "It is taken charge of other players, so you need to pay for it.", "House1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("It is taken charge of other players, so you need to pay for it.");
            p.effort -= 8;
            p.leadership -= 3;
            owner1.effort += 8;
            owner1.leadership += 3;
            JOptionPane.showMessageDialog(null, "You spend 8 effort and 3 leadership to pay for it.", "House1", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("You spend eight effort and five leadership to pay for it.");
        }
    }

    /**
     * House2
     */
    public void takechargeof2(Player p) {
        if (owner2 == null) {
            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Do you want to take charge of it?",
                    "House2", JOptionPane.QUESTION_MESSAGE, icon1, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Do you want to take charge of it?");
            if (n.equals("Yes")) {
                JOptionPane.showMessageDialog(null, "Nice choice. Now you are taking charge of it.", "House2", JOptionPane.INFORMATION_MESSAGE, icon4);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Nice choice. Now you are taking charge of it.");
                p.effort -= 25;
                p.leadership -= 15;
                p.own += "House2 ";
                JOptionPane.showMessageDialog(null, "You spend 25 effort and 15 leadership to take charge of it.", "House2", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("You spend twenty five effort and fifteen to take charge of it.");
                owner2 = p;
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You miss the chance to take charge of it.", "House2", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You miss the chance to take charge of it.");
            }
        } else if (owner2 != null) {
            JOptionPane.showMessageDialog(null, "It is taken charge of other players, so you need to pay for it.", "House2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("It is taken charge of other players, so you need to pay for it.");
            p.effort -= 8;
            p.leadership -= 3;
            owner2.effort += 8;
            owner2.leadership += 3;
            JOptionPane.showMessageDialog(null, "You spend 8 effort and 3 leadership to pay for it.", "House2", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("You spend eight effort and five leadership to pay for it.");
        }
    }

    /**
     * House3
     */
    public void takechargeof3(Player p) {
        if (owner3 == null) {
            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Do you want to take charge of it?",
                    "House3", JOptionPane.QUESTION_MESSAGE, icon1, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Do you want to take charge of it?");
            if (n.equals("Yes")) {
                JOptionPane.showMessageDialog(null, "Nice choice. Now you are taking charge of it.", "House3", JOptionPane.INFORMATION_MESSAGE, icon4);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Nice choice. Now you are taking charge of it.");
                p.effort -= 25;
                p.leadership -= 15;
                p.own += "House3 ";
                JOptionPane.showMessageDialog(null, "You spend 25 effort and 15 leadership to take charge of it.", "House3", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("You spend twenty five effort and fifteen leadership to take charge of it.");
                owner3 = p;
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You miss the chance to take charge of it.", "House3", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You miss the chance to take charge of it.");
            }
        } else if (owner3 != null) {
            JOptionPane.showMessageDialog(null, "It is taken charge of other players, so you need to pay for it.", "House3", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("It is taken charge of other players, so you need to pay for it.");
            p.effort -= 8;
            p.leadership -= 3;
            owner3.effort += 8;
            owner3.leadership += 3;
            JOptionPane.showMessageDialog(null, "You spend 8 effort and 3 leadership to pay for it.", "House3", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("You spend eight effort and five leadership to pay for it.");
        }
    }

    /**
     * House4
     */
    public void takechargeof4(Player p) {
        if (owner4 == null) {
            String[] options = {"Yes", "No"};
            String n = (String) JOptionPane.showInputDialog(null, "Do you want to take charge of it?",
                    "House4", JOptionPane.QUESTION_MESSAGE, icon1, options, options[1]);
            System.out.println(n);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("Do you want to take charge of it?");
            if (n.equals("Yes")) {
                JOptionPane.showMessageDialog(null, "Nice choice. Now you are taking charge of it.", "House4", JOptionPane.INFORMATION_MESSAGE, icon4);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Nice choice. Now you are taking charge of it.");
                p.effort -= 25;
                p.leadership -= 15;
                p.own += "House4 ";
                JOptionPane.showMessageDialog(null, "You spend 25 effort and 15 leadership to take charge of it.", "House4", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("You spend twenty five effort and fifteen leadership to take charge of it.");
                owner4 = p;
            } else if (n.equals("No")) {
                JOptionPane.showMessageDialog(null, "Oh...You miss the chance to take charge of it.", "House4", JOptionPane.INFORMATION_MESSAGE, icon1);
                if (voiceAnnouncementsUtil != null)
                    voiceAnnouncementsUtil.strat("Oh...You miss the chance to take charge of it.");
            }
        } else if (owner4 != null) {
            JOptionPane.showMessageDialog(null, "It is taken charge of other players, so you need to pay for it.", "House4", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("It is taken charge of other players, so you need to pay for it.");
            p.effort -= 8;
            p.leadership -= 3;
            owner4.effort += 8;
            owner4.leadership += 3;
            JOptionPane.showMessageDialog(null, "You spend 8 effort and 3 leadership to pay for it.", "House4", JOptionPane.INFORMATION_MESSAGE, icon1);
            if (voiceAnnouncementsUtil != null)
                voiceAnnouncementsUtil.strat("You spend eight effort and five leadership to pay for it.");
        }
    }
}
