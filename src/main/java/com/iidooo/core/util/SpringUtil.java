package com.iidooo.core.util;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring框架共通处理类
 * 
 * @author wangyixian
 * 
 */
public class SpringUtil {
    private static final Logger logger = Logger.getLogger(SpringUtil.class);

    public static Object getBean(ServletContext sc, String beanName) {
        try {
            ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sc);
            Object beanObj = appContext.getBean(beanName);
            return beanObj;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
}
