package com.iidooo.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {
    private static final Logger logger = Logger.getLogger(DateUtil.class);

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE = "yyyy-MM-dd";
    
    public static final String FORMAT_DATE_SIMPLE = "yyyyMMdd";

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
            if (inputStr == null || inputStr.isEmpty()) {
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
