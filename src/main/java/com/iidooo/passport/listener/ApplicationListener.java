package com.iidooo.passport.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.util.SpringUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dao.extend.SecurityResourceDao;
import com.iidooo.passport.dto.extend.SecurityResourceDto;

public class ApplicationListener extends HttpServlet implements ServletContextListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ApplicationListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            
            String passportURL = sc.getInitParameter(PassportConstant.PASSPORT_URL);
            sc.setAttribute(PassportConstant.PASSPORT_URL, passportURL);
            
            SecurityResourceDao securityResDao = (SecurityResourceDao) SpringUtil.getBean(sc, PassportConstant.BEAN_SECURITY_RESOURCE_DAO);
            List<SecurityResourceDto> securityResList = securityResDao.selectAll();
            sc.setAttribute(PassportConstant.SECURITY_RESOURCE_LIST, securityResList);

            // Set the security resource map into the servlet context.
//            Map<String, SecurityResourceDto> rootSecurityResMap = this.constructSecurityResRelation(securityResList);
//            sc.setAttribute(PassportConstant.SECURITY_RESOURCE_MAP, rootSecurityResMap);

            // Set the security resource tree into the servlet context.
//            List<SecurityResourceDto> rootList = new ArrayList<SecurityResourceDto>();
//            for (SecurityResourceDto item : securityResList) {
//                if (item.getParentID() <= 0) {
//                    rootList.add(item);
//                }
//            }
            //sc.setAttribute(AttributeConstants.MODULE_LIST, rootList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private Map<String, SecurityResourceDto> constructSecurityResRelation(List<SecurityResourceDto> securityResList) {
        try {
            Map<String, SecurityResourceDto> resultMap = new HashMap<String, SecurityResourceDto>();

            Map<Integer, SecurityResourceDto> securityResIDMap = new HashMap<Integer, SecurityResourceDto>();

            // Construct the result map first.
            for (SecurityResourceDto item : securityResList) {
                resultMap.put(item.getResourceURL(), item);
                securityResIDMap.put(item.getResourceID(), item);
            }

            // Set the security res's children list
            for (SecurityResourceDto item : securityResList) {
                if (item.getParentID() > 0) {
                    // Set the child into the parent module.
                    SecurityResourceDto parent = securityResIDMap.get(item.getParentID());
                    parent.getChildren().add(item);
                }
            }

            // Set the security res's off spring list.
            for (SecurityResourceDto item : securityResList) {
                SecurityResourceDto parent = securityResIDMap.get(item.getParentID());
                while (parent != null) {
                    parent.getOffspring().add(item);
                    parent = securityResIDMap.get(parent.getParentID());
                }
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
