package com.iidooo.cms.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.core.util.PropertiesUtil;

public class SystemListener extends HttpServlet implements ServletContextListener {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(SystemListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();

            {
                // 把 system.properties 加入 ServletContext
                Properties systemProperties = PropertiesUtil.loadProperties("system.properties");
                Iterator<Entry<Object, Object>> it = systemProperties.entrySet().iterator();
                while (it.hasNext()) {
                    Entry<Object, Object> entry = it.next();
                    String key = entry.getKey().toString();
                    String value = entry.getValue().toString();
                    sc.setAttribute(key, value);
                }
            }

            // 把 mail.properties 加入 ServletContext
            Properties mailProperties = PropertiesUtil.loadProperties("mail.properties");
            sc.setAttribute("mail.properties", mailProperties);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
