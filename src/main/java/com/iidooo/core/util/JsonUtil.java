package com.iidooo.core.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.iidooo.core.constant.CoreConstants;

public class JsonUtil {
    
    private static final Logger logger = Logger.getLogger(JsonUtil.class);
    
    public static void responseObject(Object object, HttpServletResponse response){
        try {
            JSONObject jsonObject = JSONObject.fromObject(object);
            response.setContentType(CoreConstants.APPLICATION_JSON);
            response.setCharacterEncoding(CoreConstants.ENCODING_UTF8);
            PrintWriter writer = response.getWriter();
            writer.write(jsonObject.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
