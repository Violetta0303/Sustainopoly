package videoplayer.dll;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface DLL extends Library {
    DLL dll = Native.load("choosefiles", DLL.class);

    String chooseFiles();
}
