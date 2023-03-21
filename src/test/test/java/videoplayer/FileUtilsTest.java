package videoplayer;

import org.junit.jupiter.api.Test;
import videoplayer.utils.FileUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

/**
 * @ClassName: FileUtilsTest
 * @Description:
 * @Author:
 * @Date: 2023-03-16 22:04:35
 */
public class FileUtilsTest {

    @Test
    public void testReadFilePath() {
        List<String> list = FileUtils.readFilePath("src/main/java/web");
        assertEquals(1, list.size());
    }

    @Test
    public void testReadAllFilePath() {
        List<String> list = FileUtils.readAllFilePath("src/main/java/web");
        assertEquals(1, list.size());
    }

    @Test
    public void testGetFileName() {
        assertEquals("web", FileUtils.getFileName("src/main/java/web"));
    }
}
