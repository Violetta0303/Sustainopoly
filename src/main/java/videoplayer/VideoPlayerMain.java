package videoplayer;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.sun.jna.NativeLibrary;
import org.apache.log4j.BasicConfigurator;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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

        Window frame = new Window();

    }

}
