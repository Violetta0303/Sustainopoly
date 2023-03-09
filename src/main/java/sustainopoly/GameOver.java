package sustainopoly;


import playersInformation.FrameConfig;
import videoplayer.VideoPlayerMain;

import javax.swing.*;
import java.awt.*;

import static sustainopoly.GameData.*;
import static sustainopoly.GamePanel.event;

public class GameOver extends JPanel {

    @Override
    public void paint(Graphics g) {
        draw(g);
        super.paintChildren(g);
    }
    Player[] players = {Player1, Player2, Player3, Player4, Player5, Player6, Player7, Player8};

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2= new JLabel();
    JLabel jLabel3= new JLabel();
    JLabel jLabel4= new JLabel();
    JLabel jLabel5= new JLabel();
    JLabel jLabel6= new JLabel();
    JLabel jLabel7= new JLabel();
    JLabel jLabel8= new JLabel();

    public void rank() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7 - i; j++) {
                if ((players[j].leadership+players[j].program+players[j].exp) < (players[j+1].leadership+players[j+1].program+players[j+1].exp)) {
                    Player p_tmp;
                    p_tmp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = p_tmp;

                    ImageIcon ava_tmp;
                    ava_tmp = FrameConfig.img[FrameConfig.selected[j]];
                    FrameConfig.img[FrameConfig.selected[j]] = FrameConfig.img[FrameConfig.selected[j + 1]];
                    FrameConfig.img[FrameConfig.selected[j + 1]] = ava_tmp;

                    String id_tmp;
                    id_tmp = FrameConfig.selectedName[j];
                    FrameConfig.selectedName[j] = FrameConfig.selectedName[j + 1];
                    FrameConfig.selectedName[j + 1] = id_tmp;
                }else if((players[j].leadership+players[j].program+players[j].exp) == (players[j+1].leadership+players[j+1].program+players[j+1].exp)){
                    if(players[j].effort<players[j+1].effort){
                        Player p_tmp;
                        p_tmp = players[j];
                        players[j] = players[j + 1];
                        players[j + 1] = p_tmp;

                        ImageIcon ava_tmp;
                        ava_tmp = FrameConfig.img[FrameConfig.selected[j]];
                        FrameConfig.img[FrameConfig.selected[j]] = FrameConfig.img[FrameConfig.selected[j + 1]];
                        FrameConfig.img[FrameConfig.selected[j + 1]] = ava_tmp;

                        String id_tmp;
                        id_tmp = FrameConfig.selectedName[j];
                        FrameConfig.selectedName[j] = FrameConfig.selectedName[j + 1];
                        FrameConfig.selectedName[j + 1] = id_tmp;
                    }
                }
            }
        }
        jLabel1.setIcon(FrameConfig.img[FrameConfig.selected[0]]);
        jLabel2.setIcon(FrameConfig.img[FrameConfig.selected[1]]);
        jLabel3.setIcon(FrameConfig.img[FrameConfig.selected[2]]);
        jLabel4.setIcon(FrameConfig.img[FrameConfig.selected[3]]);
        jLabel5.setIcon(FrameConfig.img[FrameConfig.selected[4]]);
        jLabel6.setIcon(FrameConfig.img[FrameConfig.selected[5]]);
        jLabel7.setIcon(FrameConfig.img[FrameConfig.selected[6]]);
        jLabel8.setIcon(FrameConfig.img[FrameConfig.selected[7]]);
    }

    public void draw(Graphics g) {

        rank();

        Color c = g.getColor();
        Font f = g.getFont();
        g.setColor(new Color(170, 107, 107));
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("Rank  of  Players", 350, 35);


        g.drawString("1", 25, 150);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[0].effort, 240, 100);
        g.drawString("Leadership: " + players[0].leadership, 240, 130);
        g.drawString("Programming Skills: " + players[0].program, 240, 160);
        g.drawString("Experience: " + players[0].exp, 240, 190);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[0], 100, 230);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("2", 25, 320);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[1].effort, 240, 270);
        g.drawString("Leadership: " + players[1].leadership, 240, 300);
        g.drawString("Programming Skills: " + players[1].program, 240, 330);
        g.drawString("Experience: " + players[1].exp, 240, 360);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[1], 100, 400);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("3", 25, 490);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[2].effort, 240, 440);
        g.drawString("Leadership: " + players[2].leadership, 240, 470);
        g.drawString("Programming Skills: " + players[2].program, 240, 500);
        g.drawString("Experience: " + players[2].exp, 240, 530);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[2], 100, 570);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("4", 25, 660);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[3].effort, 240, 610);
        g.drawString("Leadership: " + players[3].leadership, 240, 640);
        g.drawString("Programming Skills: " + players[3].program, 240, 670);
        g.drawString("Experience: " + players[3].exp, 240, 700);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[3], 100, 740);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("5", 515, 150);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[4].effort, 730, 100);
        g.drawString("Leadership: " + players[4].leadership, 730, 130);
        g.drawString("Programming Skills: " + players[4].program, 730, 160);
        g.drawString("Experience: " + players[4].exp, 730, 190);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[4], 590, 230);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("Rank  of  Players", 350, 35);
        g.drawString("6", 515, 320);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[5].effort, 730, 270);
        g.drawString("Leadership: " + players[5].leadership, 730, 300);
        g.drawString("Programming Skills: " + players[5].program, 730, 330);
        g.drawString("Experience: " + players[5].exp, 730, 360);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[5], 590, 400);


        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("7", 515, 490);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[6].effort, 730, 440);
        g.drawString("Leadership: " + players[6].leadership, 730, 470);
        g.drawString("Programming Skills: " + players[6].program, 730, 500);
        g.drawString("Experience: " + players[6].exp, 730, 530);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[6], 590, 570);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        g.drawString("8", 515, 660);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Effort: " + players[7].effort, 730, 610);
        g.drawString("Leadership: " + players[7].leadership, 730, 640);
        g.drawString("Programming Skills: " + players[7].program, 730, 670);
        g.drawString("Experience: " + players[7].exp, 730, 700);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(FrameConfig.selectedName[7], 590, 740);

        g.setFont(f);
        g.setColor(c);
    }

    public GameOver() {

        jLabel1.setBounds(100, 80, 110, 110);
        this.add(jLabel1);

        jLabel2.setBounds(100, 250, 110, 110);
        this.add(jLabel2);

        jLabel3.setBounds(100, 420, 110, 110);
        this.add(jLabel3);

        jLabel4.setBounds(100, 590, 110, 110);
        this.add(jLabel4);

        jLabel5.setBounds(590, 80, 110, 110);
        this.add(jLabel5);

        jLabel6.setBounds(590, 250, 110, 110);
        this.add(jLabel6);

        jLabel7.setBounds(590, 420, 110, 110);
        this.add(jLabel7);

        jLabel8.setBounds(590, 590, 110, 110);
        this.add(jLabel8);

        playEasterEgg();
    }

    public void playEasterEgg() {
        //If all the tasks have been done, play the Easter Egg Animation
        if (event.flag_MentalHealthCentre == 0 && event.flag_FoodBank == 0 && event.flag_ActivityCentre == 0
                && event.flag_Market == 0 && event.flag_SocialMedia == 0 && event.flag_Radio == 0) {
            try {
                VideoPlayerMain.init();
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
