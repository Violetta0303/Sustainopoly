package videoplayer.utils;

import java.text.DecimalFormat;

public class NumberUtil {

    public static double formatNumber(double value, int decimal) {
        // Retain decimal places
        String format = String.format("%0" + decimal + "d", 0);
        DecimalFormat df = new DecimalFormat("#." + format);
        return Float.parseFloat(df.format(value));
    }

}
