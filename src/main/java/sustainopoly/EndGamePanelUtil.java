package sustainopoly;

import javax.swing.*;

public class EndGamePanelUtil extends JFrame {

    public static void init(){

        JFrame endFrame = new JFrame("GAME OVER");

        //Set Game's LOGO
        endFrame.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        endFrame.setBounds(100,10,1050,800);

        endFrame.setLocationRelativeTo(null);

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        endFrame.setResizable(false);

        GameOver gameOver = new GameOver();
        gameOver.setLayout(null);

        endFrame.getContentPane().add(gameOver);
        endFrame.setVisible(true);
    }

}
