package sustainopoly;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: IoUtilTest
 * @Description:
 * @Author:
 * @Date: 2023-03-19 10:43:21
 */
public class IoUtilTest {

    @Test
    public void testReadFromFile() {
        assertEquals(null, IoUtil.readFromFile(""));
    }
}
