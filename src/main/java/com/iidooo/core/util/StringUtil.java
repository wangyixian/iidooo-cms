package com.iidooo.core.util;

import org.apache.log4j.Logger;

/**
 * The Utility Class of String Operation
 * 
 * @author Ethan
 *
 */
public class StringUtil {

    private static final Logger logger = Logger.getLogger(StringUtil.class);

    /**
     * Replace the old string by the array of new strings. The old string's {1}, {2}... are the replace object.
     * 
     * @param old This old string should be replaced.
     * @param news These new strings will replace the old string's {1}, {2}
     * @return The result of the replace string.
     */
    public static String replace(String old, String... news) {
        try {
            String result = old;
            for (int i = 0; i < news.length; i++) {
                if (news[i] == null) {
                    continue;
                }
                result = result.replace("{" + i + "}", news[i]);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return old;
        }
    }

    public static String substring(String str, int start, int end) {
        try {
            if (str == null || str.isEmpty()) {
                return "";
            }
            
            String result = str;
            if (str.length() < (start + end)) {
                logger.warn("The input string is not long enough!");
                return str;
            }
            
            str.substring(start, end);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return str;
        }
    }
}
