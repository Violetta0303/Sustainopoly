package sustainopoly;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javazoom.jl.decoder.JavaLayerException;
import playersInformation.FrameConfig;
import videoplayer.VideoPlayerMain;
import videoplayer.VideoPlayerWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.Locale;

import static sustainopoly.GameData.*;
//import static sustainopoly.GamePanel.event;

/**
 * Initialize Frame
 */
public class StartGame extends JFrame {

    static JFrame frame = new JFrame("Sustainopoly");
    static GamePanel gamePanel = new GamePanel();

    public void init() {
        Locale.setDefault(Locale.ENGLISH);

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize Laf");
        }

        frame.setBounds(100, 10, 1350, 810);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel.setLayout(null);

        //Set MenuBar
        frame.setJMenuBar(new MenuBar());

        //Set Game's LOGO
        frame.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        frame.getContentPane().add(gamePanel);

        frame.setVisible(true);

//        if (event.flag_MentalHealthCentre == 0 && event.flag_FoodBank == 0 && event.flag_ActivityCentre == 0
//                && event.flag_Market == 0 && event.flag_SocialMedia == 0 && event.flag_Radio == 0) {
//            EndGamePanelUtil.init();
//            frame.setVisible(false);
//        }
    }
}
