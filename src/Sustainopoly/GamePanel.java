package Sustainopoly;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Initialize Panel
 */
public class GamePanel extends JPanel implements ActionListener {


    private JLabel j1,j2;
    public  int Playpoint = 0 ;
    public int step = 78;
    public int maxpx = 910;
    public int minpx = 130;

    public int flat = 1;

    Player Player1 = new Player(GameData.play1,910,585,40,40, 195, 585);
    Player Player2 = new Player(GameData.play2,910,615,40,40, 225, 615);

    // 时间
    Date start = new Date();
    long period = 0;


    private static List<Icon> photo = new ArrayList<Icon>();   // 骰子图片

    Thread t1,t2;

    // Timer 1000ms = 1s
    Timer timer = new Timer(100, this);  // 100 毫秒 执行一次
    private ActionEvent ae;


    /**
     * Paint
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(GameData.bc, 0, 0, 1332, 772, null);

        Player1.drawMyself(g);
        playerInfor(g);


        if(flat == 1) {
            if (Playpoint != 0) {
                move(Player1,Playpoint);
                Playpoint = 0;
                events(Player1, flat);
                Playpoint = 0;
                flat = 2;
            }
        }

        Player2.drawMyself(g);
        if(flat == 2) {
            if(Playpoint!=0) {
                move(Player2, Playpoint);
                Playpoint = 0;
                events(Player2, flat);
                Playpoint = 0;
                flat = 1 ;
            }
        }


        drawTime(g);

        super.paintChildren(g);// 保持按钮不闪
    }


    /**
     * @param point is the points of Dice
     * Move the Player
     */
    public void move(Player p, int point) {
        if(p.y == p.maxpy) {
            int squ1 = (p.x - minpx) / step;
            if((squ1 - point) < 0) {
                //剩余格子数比点数小，需要向上走
                p.x = minpx;
                if((point - squ1 - 5) >= 0) {
                    //向上走的格子数也不够，需要右转
                    p.x += (point - squ1 - 5) * step;
                    p.y = p.minpy;
                }
                else {
                    //向上走的格子数够
                    p.y -= (point - squ1) * step;
                }
            }
            if((squ1 - point) >= 0 ) {
                //剩余格子比点数大，不需要转弯
                p.x -= point * step;
            }
            point = 0;
        }

        if(p.x == minpx && p.y < p.maxpy) {
            int squ2 = (p.y - p.minpy) / step;
            if((squ2 - point) < 0) {
                //剩余格子比较小，需要右转
                p.y = p.minpy;
                if((point - squ2 - 10) >= 0) {
                    //格子还是不够，还得转弯
                    p.y += (point - squ2 - 10) * step;
                    p.x = maxpx;
                }
                else {
                    //格子够，不需要转弯
                    p.x += (point - squ2) * step;
                }
            }
            if((squ2 - point) >= 0) {
                //完全不需要转弯
                p.y -= point * step;
            }
            point = 0;
        }

        if(p.y == p.minpy) {
            int squ1 = (maxpx - p.x) / step;
            if((squ1 - point) < 0) {
                //剩余格子数比点数小，需要向下走
                p.x = maxpx;
                if((point - squ1 - 5) >= 0) {
                    //向上走的格子数也不够，需要左转
                    p.x -= (point - squ1 - 5) * step;
                    p.y = p.maxpy;
                }
                else {
                    //向下走的格子数够
                    p.y += (point - squ1) * step;
                }
            }
            if((squ1 - point) >= 0 ) {
                //剩余格子比点数大，不需要转弯
                p.x += point * step;
            }
            point = 0;
        }

        if(p.x == maxpx && p.y < p.maxpy) {
            int squ2 = (p.maxpy - p.y ) / step;
            if((squ2 - point) < 0) {
                //剩余格子比较小，需要左转
                p.y = p.maxpy;
                if((point - squ2 - 10) >= 0) {
                    //格子还是不够，上转
                    p.y -= (point - squ2 - 10) * step;
                    p.x = minpx;
                }
                else {
                    //格子够，不需要转弯
                    p.x -= (point - squ2) * step;
                }
            }
            if((squ2 - point) >= 0) {
                //完全不需要转弯
                p.y += point * step;
            }
//            point = 0;
        }
    }

    /**
     * @param p is Player
     * Call the Events Class
     */
    //事件
    public void events(Player p, int flat) {
        if(flat == 1){
            Events event1 = new Events();
            if(Player1.x == 910 && Player1.y == 585){
                event1.start(p);
            }
            if((Player1.x == 832 && Player1.y == 585) || (Player1.x == 130 && Player1.y == 507)){
                event1.exchange(p);
            }
            if((Player1.x == 364 && Player1.y == 585) || (Player1.x == 910 && Player1.y == 351)){
                event1.fate(p);
            }
            if(Player1.x >= 520 && Player1.x <= 754 && Player1.y == 585){
                event1.task(p);
            }
        }else if(flat == 2){
            Events event2 = new Events();
            if(Player2.x == 910 && Player2.y == 615){
                event2.start(p);
            }
            if((Player2.x == 832 && Player2.y == 615) || (Player2.x == 130 && Player2.y == 537)){
                event2.exchange(p);
            }
            if((Player2.x == 364 && Player2.y == 615) || (Player2.x == 910 && Player2.y == 381)){
                event2.fate(p);
            }
            if(Player2.x >= 520 && Player2.x <= 754 && Player2.y == 615){
                event2.task(p);
            }
        }
    }

    /**
     * Show time and Refugees
     * @param g paint
     */
    // 画时间的函数
    public void drawTime(Graphics g) {
        Color c = g.getColor();
        Font f = g.getFont(); // 字体

        g.setFont(new Font("Arial", Font.BOLD, 25));
        int refugees = 2000;
        period = (System.currentTimeMillis() - start.getTime()) / 1000;  // 都是long类型值
        g.drawString("Game Time: " + period, 1100, 500);
        g.drawString("Refugees: " + refugees,1100,550);
        g.setFont(f);
        g.setColor(c);
    }

    /**
     * Show Player's information
     * @param g paint
     */
    // 展示玩家信息
    public void playerInfor(Graphics g) {

        Color c = g.getColor();
        Font f = g.getFont(); // 字体

        g.setFont(new Font("Arial", Font.BOLD, 15));

        g.drawString("Player1", 1150, 150);
        g.drawString("Strength: " + Player1.strength, 1150, 200);
        g.drawString("Leadership: " + Player1.leadership,1150,215);
        g.drawString("Experience: " + Player1.exp,1150,230);

        g.drawString("Player2", 1150, 280);
        g.drawString("Strength: " + Player2.strength, 1150, 330);
        g.drawString("Leadership: " + Player2.leadership,1150,345);
        g.drawString("Experience: " + Player2.exp,1150,360);

        g.setFont(f);
        g.setColor(c);
    }

    /**
     * Brush through a fixed time
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

        repaint(); // 重画页面
        timer.start();

    }

    /**
     * Thread Class for redrawing window
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();  // repaint 来自 Frame 就是 内部类调用外部类的方法 外部类继承 Frame 就有这个方法  重画窗口

                try {            // 1 s = 1000 ms  1000/50 = 20 , 1 s 20 次
                    Thread.sleep(50); // 会报错 surround and try 就可以捕抓异常
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
            offScreenImage = this.createImage(1400, 800); // 这个是游戏窗口的宽度和高度 正常可以把常量放在一个类里面

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public GamePanel() {
        JButton jButton = new JButton();
        jButton.setBounds(500, 350, 100, 100);
        jButton.setIcon(GameData.dicemodel);
        this.add(jButton);

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

        j1.setBounds(300, 300, 150, 100);
        j2.setBounds(300, 450, 150, 100);

        this.add(j1);
        this.add(j2);

        IconThread iconThread1 = new IconThread(j1, photo);
        IconThread iconThread2 = new IconThread(j2,photo);

         Dice myactionListener = new Dice();
        jButton.addActionListener(myactionListener);

        this.setFocusable(true); // 获得焦点事件

        new PaintThread().start(); // 启动重画窗口的线程

    }

    /**
     * Listen to the button
     * get the point of Dice
     */
    class Dice implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

//            thread();
            IconThread iconThread1 = new IconThread(j1,photo);
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



