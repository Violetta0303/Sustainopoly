package sustainopoly;

import javax.swing.*;

public class EndGamePanelUtil extends JFrame {
    public static JFrame endFrame;
    public static void init(){

        endFrame = new JFrame("GAME OVER");

        //Set Game's LOGO
        endFrame.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        endFrame.setBounds(100,10,1050,800);

        endFrame.setLocationRelativeTo(null);

//        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                endFrame.setVisible(false);
            }
        });

        endFrame.setResizable(false);

        GameOver gameOver = new GameOver();
        gameOver.setLayout(null);

        endFrame.getContentPane().add(gameOver);
        endFrame.setVisible(true);
    }

}
