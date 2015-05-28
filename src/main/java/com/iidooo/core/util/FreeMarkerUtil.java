package com.iidooo.core.util;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

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

    public static void setDirectiveResult(Object resultObj, String returnLable, Environment env, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        try {
            Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>();
            paramWrap.put(returnLable, DEFAULT_WRAPPER.wrap(resultObj));

            Set<Map.Entry<String, TemplateModel>> entrySet = paramWrap.entrySet();
            String key;
            TemplateModel value;
            for (Map.Entry<String, TemplateModel> entry : entrySet) {
                key = entry.getKey();
                value = entry.getValue();
                env.setVariable(key, value);
            }
            body.render(env.getOut());

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
