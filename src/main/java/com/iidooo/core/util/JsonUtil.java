package com.iidooo.core.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

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
    
    public static void responseObjectArray(Object array, HttpServletResponse response ){
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = JSONArray.fromObject(array);
            jsonObject.put(CoreConstants.REST_API_RESULT, jsonArray);
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
