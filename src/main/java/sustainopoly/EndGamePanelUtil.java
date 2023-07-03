package sustainopoly;

import videoplayer.VideoPlayerMain;

import javax.swing.*;

import static sustainopoly.GameData.event;

public class EndGamePanelUtil extends JFrame {
    public static JFrame endFrame;
    public static void init(){
        //Stop Playing the BGM
        PlayMusicUtil.close();

        endFrame = new JFrame("GAME OVER");

        //Set Game's LOGO
        endFrame.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        endFrame.setBounds(100,10,1050,800);

        endFrame.setLocationRelativeTo(null);

        endFrame.setResizable(false);

        GameOver gameOver = new GameOver();
        gameOver.setLayout(null);

        endFrame.getContentPane().add(gameOver);
        endFrame.setVisible(true);

    }

}
