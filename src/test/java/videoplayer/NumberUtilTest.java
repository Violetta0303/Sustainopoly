package videoplayer;

import org.junit.jupiter.api.Test;
import videoplayer.utils.NumberUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: NumberUtilTest
 * @Description:
 * @Author:
 * @Date: 2023-03-16 22:14:00
 */
public class NumberUtilTest {

    @Test
    public void testFormatNumber() {
        assertEquals(15.0, NumberUtil.formatNumber(15, 1));
    }
}
