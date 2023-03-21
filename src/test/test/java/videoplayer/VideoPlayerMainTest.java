package videoplayer;

import org.junit.jupiter.api.Test;

import javax.swing.UnsupportedLookAndFeelException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @ClassName: VideoPlayerMainTest
 * @Description:
 * @Author:
 * @Date: 2023-03-16 22:25:26
 */
public class VideoPlayerMainTest {

    @Test
    public void testInit() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        VideoPlayerMain.init();
        assertNotEquals(null, VideoPlayerMain.videoPlayerFrame);
    }
}
