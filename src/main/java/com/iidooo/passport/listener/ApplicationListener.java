package com.iidooo.passport.listener;

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
            List<ResourceDto> resourceList = securityResourceDao.selectAll();

            this.constructResourceRelation(resourceList);

            // Save the resource list and will be used in MenuInterceptor
            sc.setAttribute(PassportConstant.RESOURCE_LIST, resourceList);

            // Key: ResourceID
            // Value: ResourceDto
            Map<Integer, ResourceDto> resourceIDMap = new HashMap<Integer, ResourceDto>();
            // Key: ResourceURL
            // Value: ResourceDto
            Map<String, ResourceDto> resourceURLMap = new HashMap<String, ResourceDto>();
            // Key: ResourceURL
            // Value: ResourceDto
            Map<String, ResourceDto> rootResourceURLMap = new HashMap<String, ResourceDto>();

            for (ResourceDto item : resourceList) {
                if (item.getParentID() <= 0) {
                    rootResourceURLMap.put(item.getResourceURL(), item);
                }
                resourceIDMap.put(item.getResourceID(), item);
                resourceURLMap.put(item.getResourceURL(), item);
            }
            sc.setAttribute(PassportConstant.RESOURCE_ID_MAP, resourceIDMap);
            // Save the resource map and will be used in MenuInterceptor
            sc.setAttribute(PassportConstant.RESOURCE_URL_MAP, resourceURLMap);
            sc.setAttribute(PassportConstant.ROOT_RESOURCE_URL_MAP, rootResourceURLMap);

//            // Set the security resource map into the servlet context.
//            Map<String, ResourceDto> resourceURLMap = this.constructSecurityResRelation(securityResList, resourceIDMap);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void constructResourceRelation(List<ResourceDto> resourceList) {
        try {

            // Key: ResourceID
            // Value: ResourceDto
            Map<Integer, ResourceDto> resourceIDMap = new HashMap<Integer, ResourceDto>();

            // Construct the result map first.
            for (ResourceDto item : resourceList) {
                resourceIDMap.put(item.getResourceID(), item);
            }

            // Set the security res's children list
            for (ResourceDto item : resourceList) {
                if (item.getParentID() > 0) {
                    // Set the child into the parent module.
                    ResourceDto parent = resourceIDMap.get(item.getParentID());
                    if (parent == null) {
                        continue;
                    }
                    parent.getChildren().add(item);
                }
            }

            // Set the security res's off spring list.
            for (ResourceDto item : resourceList) {
                ResourceDto parent = resourceIDMap.get(item.getParentID());
                while (parent != null) {
                    parent.getOffspring().add(item);
                    parent = resourceIDMap.get(parent.getParentID());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

//    private Map<String, ResourceDto> constructSecurityResRelation(List<ResourceDto> securityResList, Map<Integer, ResourceDto> securityResIDMap) {
//        try {
//            Map<String, ResourceDto> resultMap = new HashMap<String, ResourceDto>();
//
//            // Set the security res's children list
//            for (ResourceDto item : securityResList) {
//                resultMap.put(item.getResourceURL(), item);
//                if (item.getParentID() > 0) {
//                    // Set the child into the parent module.
//                    ResourceDto parent = securityResIDMap.get(item.getParentID());
//                    if (parent == null) {
//                        continue;
//                    }
//                    parent.getChildren().add(item);
//                }
//            }
//
//            // Set the security res's off spring list.
//            for (ResourceDto item : securityResList) {
//                ResourceDto parent = securityResIDMap.get(item.getParentID());
//                while (parent != null) {
//                    parent.getOffspring().add(item);
//                    parent = securityResIDMap.get(parent.getParentID());
//                }
//            }
//            return resultMap;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.fatal(e);
//            return null;
//        }
//    }

}
