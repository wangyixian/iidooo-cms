package com.iidooo.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateTimeUtil {
    private static final Logger logger = Logger.getLogger(DateTimeUtil.class);

    public static String getNow(String format) {
        try {
            Date nowDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String now = sdf.format(nowDate);
            return now;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return "";
        }
    }

    public static String format(String inputStr, String inputFormat, String outputFormat) {
        try {
            if (StringUtil.isEmpty(inputStr)) {
                return "";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
            Date inputDate = sdf.parse(inputStr);

            sdf = new SimpleDateFormat(outputFormat);
            String outputStr = sdf.format(inputDate);
            return outputStr;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return "";
        }
    }
}
