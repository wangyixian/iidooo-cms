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
}
