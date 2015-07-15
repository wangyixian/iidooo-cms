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

import com.iidooo.core.util.SpringUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dao.extend.ResourceDao;
import com.iidooo.passport.dto.extend.ResourceDto;

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
            ResourceDao securityResourceDao = (ResourceDao) SpringUtil.getBean(sc, PassportConstant.BEAN_RESOURCE_DAO);
            List<ResourceDto> securityResList = securityResourceDao.selectAll();
            // Save the resource list and will be used in MenuInterceptor
            sc.setAttribute(PassportConstant.SESSION_RESOURCE_LIST, securityResList);

            // Key: ResourceID
            // Value: ResourceDto
            Map<Integer, ResourceDto> resourceIDMap = new HashMap<Integer, ResourceDto>();
            // Construct the result map first.
            for (ResourceDto item : securityResList) {
                resourceIDMap.put(item.getResourceID(), item);
            }
            sc.setAttribute(PassportConstant.RESOURCE_ID_MAP, resourceIDMap);

            // Set the security resource map into the servlet context.
            Map<String, ResourceDto> rootSecurityResMap = this.constructSecurityResRelation(securityResList, resourceIDMap);
            // Save the resource map and will be used in MenuInterceptor
            sc.setAttribute(PassportConstant.RESOURCE_URL_MAP, rootSecurityResMap);

            // Set the security resource tree into the servlet context.
            // List<SecurityResourceDto> rootList = new ArrayList<SecurityResourceDto>();
            // for (SecurityResourceDto item : securityResList) {
            // if (item.getParentID() <= 0) {
            // rootList.add(item);
            // }
            // }
            // sc.setAttribute(PassportConstant.SESSION_SECURITY_RESOURCE_ROOT_LIST, rootList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private Map<String, ResourceDto> constructSecurityResRelation(List<ResourceDto> securityResList, Map<Integer, ResourceDto> securityResIDMap) {
        try {
            Map<String, ResourceDto> resultMap = new HashMap<String, ResourceDto>();

            // Set the security res's children list
            for (ResourceDto item : securityResList) {
                resultMap.put(item.getResourceURL(), item);
                if (item.getParentID() > 0) {
                    // Set the child into the parent module.
                    ResourceDto parent = securityResIDMap.get(item.getParentID());
                    if (parent == null) {
                        continue;
                    }
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<ResourceDto>());
                    }
                    parent.getChildren().add(item);
                }
            }

            // Set the security res's off spring list.
            for (ResourceDto item : securityResList) {
                ResourceDto parent = securityResIDMap.get(item.getParentID());
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
