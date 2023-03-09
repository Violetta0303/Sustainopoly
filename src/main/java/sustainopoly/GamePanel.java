package sustainopoly;

import playersInformation.FrameConfig;
import videoplayer.VideoPlayerMain;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static sustainopoly.EndGamePanelUtil.endFrame;
import static sustainopoly.GameData.*;


/**
 * Initialize Panel
 */
public class GamePanel extends JPanel implements ActionListener {


    private JLabel j1, j2;
    public int Playpoint = 0;
    public int step = 81;

    public int turn = 1;

    public static GameData data = new GameData();

    public static Events event = new Events();

//    //Play the BGM
//    PlayMusicUtil bgm = new PlayMusicUtil();

    Date start = new Date();
    public static long period = 0;

    private static List<Icon> photo = new ArrayList<Icon>();
    Thread t1;
    Thread t2;

    // Timer 1000ms = 1s
    Timer timer = new Timer(100, this);
    private ActionEvent ae;

    /**
     * Paint
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(GameData.bg, 0, 0, 1329, 747, null);

        Player1.drawMyself(g);
        if (turn == 1) {
            if (Playpoint != 0) {
                move(Player1, Playpoint);
                Playpoint = 0;
                events(Player1);
                Playpoint = 0;
                turn = 2;
            }
        }

        Player2.drawMyself(g);
        if (turn == 2) {
            if (Playpoint != 0) {
                move(Player2, Playpoint);
                Playpoint = 0;
                events(Player2);
                Playpoint = 0;
                turn = 3;
            }
        }

        Player3.drawMyself(g);
        if (turn == 3) {
            if (Playpoint != 0) {
                move(Player3, Playpoint);
                Playpoint = 0;
                events(Player3);
                Playpoint = 0;
                turn = 4;
            }
        }

        Player4.drawMyself(g);
        if (turn == 4) {
            if (Playpoint != 0) {
                move(Player4, Playpoint);
                Playpoint = 0;
                events(Player4);
                Playpoint = 0;
                turn = 5;
            }
        }

        Player5.drawMyself(g);
        if (turn == 5) {
            if (Playpoint != 0) {
                move(Player5, Playpoint);
                Playpoint = 0;
                events(Player5);
                Playpoint = 0;
                turn = 6;
            }
        }

        Player6.drawMyself(g);
        if (turn == 6) {
            if (Playpoint != 0) {
                move(Player6, Playpoint);
                Playpoint = 0;
                events(Player6);
                Playpoint = 0;
                turn = 7;
            }
        }

        Player7.drawMyself(g);
        if (turn == 7) {
            if (Playpoint != 0) {
                move(Player7, Playpoint);
                Playpoint = 0;
                events(Player7);
                Playpoint = 0;
                turn = 8;
            }
        }

        Player8.drawMyself(g);
        if (turn == 8) {
            if (Playpoint != 0) {
                move(Player8, Playpoint);
                Playpoint = 0;
                events(Player8);
                Playpoint = 0;
                turn = 1;
            }
        }

        drawTime(g);

        super.paintChildren(g);// Keep the button

    }


    /**
     * @param point is the points of Dice
     *              Move the Player
     */
    public void move(Player p, int point) {
        if (p.y == p.maxpy) {
            int squ1 = (p.x - p.minpx) / step;
            if ((squ1 - point) < 0) {
                p.x = p.minpx;
                if ((point - squ1 - 5) >= 0) {
                    p.x += (point - squ1 - 5) * step;
                    p.y = p.minpy;
                } else {
                    p.y -= (point - squ1) * step;
                }
            }
            if ((squ1 - point) >= 0) {
                p.x -= point * step;
            }
            point = 0;
        }

        if (p.x == p.minpx && p.y < p.maxpy) {
            int squ2 = (p.y - p.minpy) / step;
            if ((squ2 - point) < 0) {
                p.y = p.minpy;
                if ((point - squ2 - 10) >= 0) {
                    p.y += (point - squ2 - 10) * step;
                    p.x = p.maxpx;
                } else {
                    p.x += (point - squ2) * step;
                }
            }
            if ((squ2 - point) >= 0) {
                p.y -= point * step;
            }
            point = 0;
        }

        if (p.y == p.minpy) {
            int squ1 = (p.maxpx - p.x) / step;
            if ((squ1 - point) < 0) {
                p.x = p.maxpx;
                if ((point - squ1 - 5) >= 0) {
                    p.x -= (point - squ1 - 5) * step;
                    p.y = p.maxpy;
                } else {
                    p.y += (point - squ1) * step;
                }
            }
            if ((squ1 - point) > 0) {
                p.x += point * step;
            }
            point = 0;
        }

        if (p.x == p.maxpx && p.y < p.maxpy) {
            int squ2 = (p.maxpy - p.y) / step;
            if ((squ2 - point) < 0) {
                p.y = p.maxpy;
                if ((point - squ2 - 10) >= 0) {
                    p.y -= (point - squ2 - 10) * step;
                    p.x = p.minpx;
                } else {
                    p.x -= (point - squ2) * step;
                }
            }
            if ((squ2 - point) >= 0) {
                p.y += point * step;
            }

        }
    }

    /**
     * @param p is Player
     *          Call the Events Class
     */
    //
    public void events(Player p) {
        //Start
        if (p.x == p.maxpx && p.y == p.maxpy) {
            event.start(p);
        }
        //Store
        if ((p.x == p.maxpx - (2 * step) && p.y == p.maxpy) || (p.x == p.minpx && p.y == p.maxpy - step)) {
            event.store(p);
        }
        //Fate
        if ((p.x == p.maxpx - (8 * step) && p.y == p.maxpy) || (p.x == p.maxpx && p.y == p.maxpy - step)) {
            event.fate(p);
        }
        //Mental Health Centre
        if ((p.x == p.maxpx - (4 * step) && p.y == p.maxpy) || (p.x == p.maxpx - (6 * step) && p.y == p.minpy)) {
            event.mentalhealthcentre(p);
        }
        //Activity Centre
        if ((p.x == p.maxpx - (6 * step) && p.y == p.maxpy) || (p.x == p.minpx && p.y == p.maxpy - (3 * step))) {
            event.activitycentre(p);
        }
        //Food Bank
        if ((p.x == p.minpx && p.y == p.maxpy) || (p.x == p.minpx + step && p.y == p.minpy)) {
            event.foodbank(p);
        }
        //Market
        if ((p.x == p.minpx && p.y == p.minpy) || (p.x == p.maxpx - (2 * step) && p.y == p.minpy)) {
            event.market(p);
        }
        //Social Media
        if ((p.x == p.minpx + (3 * step) && p.y == p.minpy)) {
            event.socialmedia(p);
        }
        //Community Radio
        if ((p.x == p.maxpx - (3 * step) && p.y == p.minpy) || (p.x == p.maxpx && p.y == p.maxpy - (3 * step))) {
            event.Radio(p);
        }
        //Mosque
        if ((p.x == p.maxpx && p.y == p.minpy)) {
            event.mosque(p);
        }
    }

    /**
     * Show time
     *
     * @param g paint
     */
    public void drawTime(Graphics g) {
        Color c = g.getColor();
        Font f = g.getFont();

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        period = (System.currentTimeMillis() - start.getTime()) / 1000;
        g.drawString("Game Time: " + period, 780, 380);
        g.setFont(f);
        g.setColor(c);
        if (period >= 1200) {
            EndGamePanelUtil.init();
            StartGame.frame.setVisible(false);

//            //Stop Playing the BGM
//            bgm.interrupt();

            endFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    //Video Player Frame
                    //Play the Easter Egg Animation
                    try {
                        VideoPlayerMain.init();
//                        endFrame.setVisible(false);
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
            });
        }
    }

    /**
     * Brush through a fixed time
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = new Thread();
                t.start();

            }
        }).start();

        repaint();
        timer.start();

    }

    /**
     * Thread Class for redrawing window
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();

                try {// 1 s = 1000 ms  1000/50 = 20 , 1 s 20
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Dual cache
     * Solve the flicker problem
     */
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(1400, 800);

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public GamePanel() {
        JButton jButton = new JButton();
        jButton.setBounds(620, 330, 90, 90);
        jButton.setIcon(GameData.dicemodel);
        this.add(jButton);

        //P1
        JButton JBPlayer01 = new JButton(FrameConfig.img[FrameConfig.selected[0]]);
        JBPlayer01.setBounds(15, 0, 95, 95);

        Font f = new Font("Comic Sans MS", Font.BOLD, 18);
        JLabel idStr1 = new JLabel(FrameConfig.selectedName[0]);
        idStr1.setBounds(15, 100, 100, 25);
        idStr1.setFont(f);

        this.add(JBPlayer01);
        this.add(idStr1);

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Comic Sans MS", Font.BOLD, 14)));

        JBPlayer01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[0]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[0] + "\n\nEffort: " + Player1.effort +
                                "\nLeadership: " + Player1.leadership + "\nProgramming Skills: " + Player1.program + "\nExperience: " + Player1.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });


        //P2
        JButton JBPlayer02 = new JButton(FrameConfig.img[FrameConfig.selected[1]]);
        JBPlayer02.setBounds(115, 0, 95, 95);

        JLabel idStr2 = new JLabel(FrameConfig.selectedName[1]);
        idStr2.setBounds(115, 100, 100, 25);
        idStr2.setFont(f);

        this.add(JBPlayer02);
        this.add(idStr2);

        JBPlayer02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[1]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[1] + "\n\nEffort: " + Player2.effort +
                                "\nLeadership: " + Player2.leadership + "\nProgramming Skills: " + Player2.program + "\nExperience: " + Player2.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

        //P3
        JButton JBPlayer03 = new JButton(FrameConfig.img[FrameConfig.selected[2]]);
        JBPlayer03.setBounds(1120, 0, 95, 95);

        JLabel idStr3 = new JLabel(FrameConfig.selectedName[2]);
        idStr3.setBounds(1120, 100, 100, 25);
        idStr3.setFont(f);

        this.add(JBPlayer03);
        this.add(idStr3);
        JBPlayer03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[2]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[2] + "\n\nEffort: " + Player3.effort +
                                "\nLeadership: " + Player3.leadership + "\nProgramming Skills: " + Player3.program + "\nExperience: " + Player3.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

        // P4
        JButton JBPlayer04 = new JButton(FrameConfig.img[FrameConfig.selected[3]]);
        JBPlayer04.setBounds(1220, 0, 95, 95);

        JLabel idStr4 = new JLabel(FrameConfig.selectedName[3]);
        idStr4.setBounds(1220, 100, 100, 25);
        idStr4.setFont(f);

        this.add(JBPlayer04);
        this.add(idStr4);

        JBPlayer04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[3]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[3] + "\n\nEffort: " + Player4.effort +
                                "\nLeadership: " + Player4.leadership + "\nProgramming Skills: " + Player4.program + "\nExperience: " + Player4.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

        //P5
        JButton JBPlayer05 = new JButton(FrameConfig.img[FrameConfig.selected[4]]);
        JBPlayer05.setBounds(15, 650, 95, 95);

        JLabel idStr5 = new JLabel(FrameConfig.selectedName[4]);
        idStr5.setBounds(15, 620, 100, 25);
        idStr5.setFont(f);

        this.add(JBPlayer05);
        this.add(idStr5);

        JBPlayer05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[4]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[4] + "\n\nEffort: " + Player5.effort +
                                "\nLeadership: " + Player5.leadership + "\nProgramming Skills: " + Player5.program + "\nExperience: " + Player5.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });


        //P6
        JButton JBPlayer06 = new JButton(FrameConfig.img[FrameConfig.selected[5]]);
        JBPlayer06.setBounds(115, 650, 95, 95);

        JLabel idStr6 = new JLabel(FrameConfig.selectedName[5]);
        idStr6.setBounds(115, 620, 100, 25);
        idStr6.setFont(f);

        this.add(JBPlayer06);
        this.add(idStr6);

        JBPlayer06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[5]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[5] + "\n\nEffort: " + Player6.effort +
                                "\nLeadership: " + Player6.leadership + "\nProgramming Skills: " + Player6.program + "\nExperience: " + Player6.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });


        //P7
        JButton JBPlayer07 = new JButton(FrameConfig.img[FrameConfig.selected[6]]);
        JBPlayer07.setBounds(1120, 650, 95, 95);

        JLabel idStr7 = new JLabel(FrameConfig.selectedName[6]);
        idStr7.setBounds(1120, 620, 100, 25);
        idStr7.setFont(f);

        this.add(JBPlayer07);
        this.add(idStr7);

        JBPlayer07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[6]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[6] + "\n\nEffort: " + Player7.effort +
                                "\nLeadership: " + Player7.leadership + "\nProgramming Skills: " + Player7.program + "\nExperience: " + Player7.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });


        //P8
        JButton JBPlayer08 = new JButton(FrameConfig.img[FrameConfig.selected[7]]);
        JBPlayer08.setBounds(1220, 650, 95, 95);

        JLabel idStr8 = new JLabel(FrameConfig.selectedName[7]);
        idStr8.setBounds(1220, 620, 100, 25);
        idStr8.setFont(f);

        this.add(JBPlayer08);
        this.add(idStr8);

        JBPlayer08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = FrameConfig.img[FrameConfig.selected[7]];
                JOptionPane.showMessageDialog(null, "ID: " + FrameConfig.selectedName[7] + "\n\nEffort: " + Player8.effort +
                                "\nLeadership: " + Player8.leadership + "\nProgramming Skills: " + Player8.program + "\nExperience: " + Player8.exp,
                        "Player Information", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

        photo.add(GameData.DC1);
        photo.add(GameData.DC2);
        photo.add(GameData.DC3);
        photo.add(GameData.DC4);
        photo.add(GameData.DC5);
        photo.add(GameData.DC6);

        j1 = new JLabel();
        j2 = new JLabel();

        j1.setIcon(GameData.DC0);
        j2.setIcon(GameData.DC0);

        j1.setBounds(480, 270, 150, 100);
        j2.setBounds(480, 390, 150, 100);

        this.add(j1);
        this.add(j2);

        IconThread iconThread1 = new IconThread(j1, photo);
        IconThread iconThread2 = new IconThread(j2, photo);

        Dice myactionListener = new Dice();
        jButton.addActionListener(myactionListener);

        this.setFocusable(true);

//        bgm.start();

        new PaintThread().start();

    }

    /**
     * Listen to the button
     * get the point of Dice
     */
    class Dice implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

//            thread();
            IconThread iconThread1 = new IconThread(j1, photo);
            t1 = new Thread(iconThread1);
            t1.start();

            IconThread iconThread2 = new IconThread(j2, photo);
            t2 = new Thread(iconThread2);
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int dice1 = iconThread1.playerResult(j1);
            int dice2 = iconThread2.playerResult(j2);

            Playpoint = dice1 + dice2;

            System.out.println(Playpoint);

        }
    }
}



