package cxzgwing.utils;

import java.text.DecimalFormat;

public class NumberUtil {

    public static double formatNumber(double value, int decimal) {
        // 保留decimal位小数
        String format = String.format("%0" + decimal + "d", 0);
        DecimalFormat df = new DecimalFormat("#." + format);
        return Float.parseFloat(df.format(value));
    }

}
