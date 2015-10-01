package com.iidooo.core.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.core.constant.CoreConstants;

public class BaseListener extends HttpServlet implements ServletContextListener, ServletRequestListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BaseListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            ServletRequest request = arg0.getServletRequest();
            String siteUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + sc.getContextPath();
            request.setAttribute(CoreConstants.SITE_URL, siteUrl);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }
}
