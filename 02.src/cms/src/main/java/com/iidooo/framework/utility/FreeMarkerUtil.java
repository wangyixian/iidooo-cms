package com.iidooo.framework.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import freemarker.template.TemplateModel;

public class FreeMarkerUtil {
    private static final Logger logger = Logger.getLogger(FreeMarkerUtil.class);
    
    public static Map<String, Object> convertDirectiveParams(Map params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Set<Map.Entry<String, TemplateModel>> entrySet = params.entrySet();
            for (Map.Entry<String, TemplateModel> entry : entrySet) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                resultMap.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return resultMap;
    }
}
