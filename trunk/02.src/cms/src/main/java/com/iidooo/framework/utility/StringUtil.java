package com.iidooo.framework.utility;

import org.apache.log4j.Logger;

public class StringUtil {
    
    private static final Logger logger = Logger.getLogger(StringUtil.class);
    
    /**
     * 文字列是否是null或者空白的check
     *
     * @param str String check文字列
     *
     * @return boolean True:null或者是空白
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
