package sustainopoly;

import sustainopoly.Player;
import sustainopoly.VoiceAnnouncementsUtil;

import javax.swing.*;
import java.util.Random;

/**
 * Events
 */

public class Events {
    VoiceAnnouncementsUtil voice;

    int flag_MentalHealthCentre = 1;
    int flag_ActivityCentre = 1;
    int flag_FoodBank = 1;
    int flag_Market = 1;
    int flag_SocialMedia = 1;
    int flag_Radio = 1;
    int flag_Mosque = 1;

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
        int r1 = rand1.nextInt(10) + 1; //points
        Random rand2 = new Random();
        int r2 = rand2.nextInt(2); // fortunate or unfortunate
        String number[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        if (r2 == 1) {
            p.effort *= (1 + r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Congratulations! You get " + r1 + "% effort!");
            voice.strat("Congratulations! You get " + number[r1 - 1] + "percent effort!");
        } else if (r2 == 0) {
            p.effort *= (1 - r1 * 0.01);
            JOptionPane.showMessageDialog(null, "Unfortunate! You lose " + r1 + "% effort!");
            voice.strat("Unfortunate! You lose " + number[r1 - 1] + "percent effort!");
        }
    }

    /**
     * Store
     */
    public void store(Player p) {
        JOptionPane.showMessageDialog(null, "Welcome to 'Store'!");
        voice.strat("Welcome to 'Store'!");

        String[] options1 = {"Choose the character you want to exchange", "Effort", "Leadership", "Programming Skills"};
        ImageIcon icon = new ImageIcon("src/main/java/images/Icon/Store.png");
        String n1 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options1, options1[2]);
        System.out.println(n1);
        voice.strat("Choose the character you want to exchange");

        String[] options2 = {"Choose the character you want to get", "Effort", "Leadership", "Programming Skills"};
        String n2 = (String) JOptionPane.showInputDialog(null, "Choose the exchange character",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options2, options2[2]);
        System.out.println(n2);
        voice.strat("Choose the character you want to get");

        String[] options3 = {"Choose the points you want to exchange", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String n3 = (String) JOptionPane.showInputDialog(null, "Choose the points",
                "Store", JOptionPane.QUESTION_MESSAGE, icon, options3, options3[2]);
        System.out.println(n3);
        voice.strat("Choose the  points you want to exchange");

        int a = Integer.parseInt(n3);

        if (n1 == "Effort") {
            p.effort -= a;
            if (n2 == "Leadership") {
                p.leadership += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2 == "Programming Skills") {
                p.program += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                voice.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }
        } else if (n1 == "Leadership") {
            p.leadership -= a;
            if (n2 == "Effort") {
                p.effort += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2 == "Programming Skills") {
                p.program += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                voice.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }
        } else if (n1 == "Programming Skills") {
            p.program -= a;
            if (n2 == "Effort") {
                p.effort += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else if (n2 == "Leadership") {
                p.leadership += a;
                voice.strat("Successful!");
                JOptionPane.showMessageDialog(null, "Successful!");
            } else {
                voice.strat("Please select different characters!");
                JOptionPane.showMessageDialog(null, "Please select different characters!");
            }

        }
    }

    /**
     * Mental Health Centre
     */
    public void mentalhealthcentre(Player p) {

        if (flag_MentalHealthCentre != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Mental Health Centre'!");
            voice.strat("Welcome to 'Mental Health Centre'!");

            String[] options = {"Could you please help us to improve residents' mental health?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "Task",
                    "Mental Health Centre", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please have me to improve residents' mental health?");

            if (n == "Yes") {
                if (flag_MentalHealthCentre == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to set up the Mental Health website to present the content of the Antidepressant Skills Guide in a multimedia format.");
                    p.effort -= 20;
                    p.leadership += 5;
                    p.program += 10;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 program skills and 5 experience", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose twenty effort, but gain five leadership, ten program skills and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre = 2;
                } else if (flag_MentalHealthCentre == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to create a calendar reminder on the website to remind residents to complete the guide every day.");
                    p.effort -= 10;
                    p.leadership += 2;
                    p.program += 5;
                    p.exp += 2;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 2 leadership, 5 program skills and 2 experience.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain two leadership, five program skills and two experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre = 3;
                } else if (flag_MentalHealthCentre == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! In order to accommodate residents who do not have easy access to the internet, we need to distribute paper copies of the guide, the scales and psychology-related books.");
                    p.effort -= 5;
                    p.exp += 2;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 experience.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose five effort, but gain two experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_MentalHealthCentre = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        } else if (flag_MentalHealthCentre == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Mental Health Centre have been done. Thanks for your help!", "Mental Health Centre", JOptionPane.INFORMATION_MESSAGE, icon);
            voice.strat("All the tasks in Mental Health Centre have been done. Thanks for your help!");
        }
    }

    /**
     * Food Bank
     */
    public void foodbank(Player p) {

        if (flag_FoodBank != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Food Bank'!");
            voice.strat("Welcome to 'Food Bank'!");

            String[] options = {"Could you please help us to improve food bank?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "Food Bank",
                    "Food Bank", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us to improve food bank?");

            if (n == "Yes") {
                if (flag_FoodBank == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to visit the Food Bank to find out the type of food, the average daily quantity and the operation of the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership and 5 experience", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain five leadership and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!");
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank = 2;
                } else if (flag_FoodBank == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to cooperate with the Food Bank to obtain detailed daily food information from the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership and 5 experience.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain two leadership and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!");
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank = 3;
                } else if (flag_FoodBank == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to create a Food Information website where we can display the types and quantities of food available at the Food Bank.");
                    p.effort -= 20;
                    p.leadership += 5;
                    p.program += 10;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 20 effort, but gain 5 leadership, 10 programming skills and 5 experience.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose 20 effort, but gain five leadership, ten programming skills and 5 experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!");
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank = 4;
                } else if (flag_FoodBank == 4) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to connect the website to the Food Bank to enable real-time updates of Food Information.");
                    p.effort -= 10;
                    p.leadership += 3;
                    p.program += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 3 leadership, 5 programming skills and 3 experience.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain three leadership, five programming skills and 3 experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_FoodBank = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        } else if (flag_FoodBank == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Food Bank have been done. Thanks for your help!", "Food Bank", JOptionPane.INFORMATION_MESSAGE, icon);
            voice.strat("All the tasks in Food Bank have been done. Thanks for your help!");
        }

    }

    /**
     * Mosque
     */
    public void mosque(Player p) {

        if (flag_Mosque != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Mosque'!");
            voice.strat("Welcome to 'Mosque'!");

            String[] options = {"Could you please help us to get Halal Food?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "",
                    "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us to get Halal Food?");

            if (n == "Yes") {
                if (flag_Mosque == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to visit Mosque to understand the food needs of the Muslim population.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to visit Mosque to understand the food needs of the Muslim population.");
                    p.effort -= 8;
                    p.leadership += 4;
                    p.exp += 4;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 4 leadership, and 4 experience", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose eight effort, but gain four leadership, and four experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 2;
                } else if (flag_Mosque == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to communicate with both Food Bank and Mosque to establish cooperation between them.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to communicate with both Food Bank and Mosque to establish cooperation between them.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 3;
                } else if (flag_Mosque == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to get halal food to meet the basic food needs of the Muslim residents.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to get halal food to meet the basic food needs of the Muslim residents.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership and 3 experience.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose five effort, but gain two leadership and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Mosque = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        } else if (flag_Mosque == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Mosque have been done. Thanks for your help!", "Mosque", JOptionPane.INFORMATION_MESSAGE, icon);
            voice.strat("All the tasks in Mosuqe have been done. Thanks for your help!");
        }
    }

    /**
     * Market
     */
    public void market(Player p) {

        if (flag_Market != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Market'!");
            voice.strat("Welcome to 'Market'!");

            String[] options = {"Could you please help us to get more Food?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "",
                    "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us to get more Food?");

            if (n == "Yes") {
                if (flag_Market == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to know the information on the Market's daily food surplus.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to know the information on the Market's daily food surplus.");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership, and 3 experience", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose five effort, but gain two leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Market = 2;
                } else if (flag_Market == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to communicate with the Market management to get the Market to provide excess food to the Food Bank and build closer cooperation with the Food Bank.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to communicate with the Market management to get the Market to provide excess food to the Food Bank and build closer cooperation with the Food Bank.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Market = 3;
                } else if (flag_Market == 3) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to get the food from the Market and transport it to the Food Bank so that the inhabitants can have enough food in the Food Bank.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to get the food from the Market and transport it to the Food Bank so that the inhabitants can have enough food in the Food Bank");
                    p.effort -= 5;
                    p.leadership += 2;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 5 effort, but gain 2 leadership, and 3 experience.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose five effort, but gain two leadership, and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Market = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        } else if (flag_Market == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Market have been done. Thanks for your help!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
            voice.strat("All the tasks in Market have been done. Thanks for your help!");
        }
    }

    /**
     * Social Media
     */
    public void socialmedia(Player p) {
        if (flag_SocialMedia != 0) {
            JOptionPane.showMessageDialog(null, "Welcome to 'Social Media'!");
            voice.strat("Welcome to 'Social Media'!");

            String[] options = {"Could you please help us to promote and advertise on Social Media?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "",
                    "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us to promote and advertise on Social Media?");

            if (n == "Yes") {
                if (flag_SocialMedia == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to use Social Media to promote Food issues and Mental health issues.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to use Social Media to promote Food issues and Mental Health issues.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain five leadership, and five experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_SocialMedia = 2;
                } else if (flag_SocialMedia == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to attract more volunteers and donors, as well as raise public awareness of Food issues and Mental Health issues.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to attract more volunteers and donors, as well as raise public awareness of Food issues and Mental Health issues.");
                    p.effort -= 10;
                    p.leadership += 5;
                    p.exp += 5;
                    JOptionPane.showMessageDialog(null, "You lose 10 effort, but gain 5 leadership, and 5 experience.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose ten effort, but gain five leadership, and five experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_SocialMedia = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        } else if (flag_SocialMedia == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Social Media have been done. Thanks for your help!", "Social Media", JOptionPane.INFORMATION_MESSAGE, icon);
            voice.strat("All the tasks in Social Media have been done. Thanks for your help!");
        }
    }

    /**
     * Community Radio
     */
    public void Radio(Player p) {

        if(flag_Radio!=0){
            JOptionPane.showMessageDialog(null, "Welcome to 'Community Radio'!");
            voice.strat("Welcome to 'Community Radio'!");

            String[] options = {"Could you please help us with the broadcast?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "",
                    "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us with the broadcast?");

            if (n == "Yes") {
                if (flag_Radio == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast the Food Bank's real-time Food Information, helping residents who do not have easy access to the internet to get real-time Food Information.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to broadcast the Food Bank's real-time Food Information, helping residents who do not have easy access to the internet to get real-time Food Information.");
                    p.effort -= 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 3 effort, but gain 3 experience", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose three effort, but gain three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!");
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Radio = 2;
                } else if (flag_Radio == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to broadcast Mental Health knowledge to help residents improve their Mental Health.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to broadcast Mental Health knowledge to help residents improve their Mental Health.");
                    p.effort -= 3;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 3 effort, but gain 3 experience.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose three effort, but gain three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_Radio = 0;
                } else if (n == "No") {
                    JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Oh...You are such a cold person.");
                }
            }
        }else if (flag_Radio == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Community Radio have been done. Thanks for your help!","Community Radio",JOptionPane.INFORMATION_MESSAGE,icon);
            voice.strat("All the tasks in Community Radio have been done. Thanks for your help!");
        }
    }

    /**
     * Activity Centre
     */
    public void activitycentre(Player p) {

        if(flag_ActivityCentre!=0){
            JOptionPane.showMessageDialog(null, "Welcome to 'Activity Centre'!");
            voice.strat("Welcome to 'Activity Centre'!");

            String[] options = {"Could you please help us to organise activities?", "Yes", "No"};
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            String n = (String) JOptionPane.showInputDialog(null, "",
                    "", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);
            System.out.println(n);
            voice.strat("Could you please help us to organise activities?");

            if (n == "Yes") {
                if (flag_ActivityCentre == 1) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to organise events, tea parties, etc. to strengthen the ties between residents and increase their sense of belonging to the community.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to organise events, tea parties, etc. to strengthen the ties between residents and increase their sense of belonging to the community.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 3 leadership, and 5 experience", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose eight effort, but gain five leadership, and three experience");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre = 2;
                } else if (flag_ActivityCentre == 2) {
                    JOptionPane.showMessageDialog(null, "Let's start! We need to conduct science talks on Food, Mental Health and other topics to raise awareness of environmental and health issues among residents.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Let's start! We need to conduct science talks on Food, Mental Health and other topics to raise awareness of environmental and health issues among residents.");
                    p.effort -= 8;
                    p.leadership += 5;
                    p.exp += 3;
                    JOptionPane.showMessageDialog(null, "You lose 8 effort, but gain 5 leadership, and 3 experience.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("You lose eight effort, but gain five leadership, and three experience.");
                    JOptionPane.showMessageDialog(null, "Thank you for your contribution to Govan!", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                    voice.strat("Thank you for your contribution to Govan!");
                    flag_ActivityCentre = 0;
                }
            } else if (n == "No") {
                JOptionPane.showMessageDialog(null, "Oh...You are such a cold person.", "Market", JOptionPane.INFORMATION_MESSAGE, icon);
                voice.strat("Oh...You are such a cold person.");
            }
        }else if (flag_ActivityCentre == 0) {
            ImageIcon icon = new ImageIcon("src/main/java/images/Coco/Coco.png");
            JOptionPane.showMessageDialog(null, "All the tasks in Activity Centre have been done. Thanks for your help!","Activity Centre",JOptionPane.INFORMATION_MESSAGE,icon);
            voice.strat("All the tasks in Activity Centre have been done. Thanks for your help!");
        }
    }
}
