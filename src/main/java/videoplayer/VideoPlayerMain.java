package videoplayer;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.sun.jna.NativeLibrary;
import org.apache.log4j.BasicConfigurator;
import sustainopoly.StartGame;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;

public class VideoPlayerMain {
    public static VideoPlayerWindow videoPlayerFrame;

    public static void init() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize Laf" );
        }

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        // Resolve logging error reporting issues
        BasicConfigurator.configure();

        // Close log
        // Logger.getRootLogger().shutdown();

        // Load dll
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "vlc");

        videoPlayerFrame = new VideoPlayerWindow();

    }

}
