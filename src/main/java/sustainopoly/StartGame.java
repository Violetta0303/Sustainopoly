package game;

import javax.swing.*;

/**
 *  Initialize Frame
 */
public class StartGame extends JFrame{

    public void init(){

        JFrame frame = new JFrame("game");

        frame.setBounds(110,30,1332,772);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setLayout(null);

        frame.getContentPane().add(gamePanel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        StartGame startGame = new StartGame();
        startGame.init();
    }
}
