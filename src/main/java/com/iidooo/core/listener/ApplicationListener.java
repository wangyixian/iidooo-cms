package com.iidooo.core.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dao.extend.DictItemDao;
import com.iidooo.core.dto.extend.DictItemDto;
import com.iidooo.core.util.SpringUtil;

public class ApplicationListener extends HttpServlet implements ServletContextListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ApplicationListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            // String coreURL = sc.getInitParameter(CoreConstants.CORE_URL);
            // sc.setAttribute(CoreConstants.CORE_URL, coreURL);

            DictItemDao dictItemDao = (DictItemDao) SpringUtil.getBean(sc, CoreConstants.BEAN_DICT_ITEM_DAO);

            this.setAttribute(sc, dictItemDao, CoreConstants.DICT_CLASS_CORE_PAGE);
            this.setAttribute(sc, dictItemDao, CoreConstants.DICT_CLASS_CORE_UPLOAD);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void setAttribute(ServletContext sc, DictItemDao dictItemDao, String classCode) {
        try {
            List<DictItemDto> dictItemList = dictItemDao.selectByClassCode(classCode);
            // Save the page properties into the application context
            Map<String, DictItemDto> dictItemMap = new HashMap<String, DictItemDto>();
            for (DictItemDto dictItemDto : dictItemList) {
                dictItemMap.put(dictItemDto.getDictItemCode(), dictItemDto);
            }
            sc.setAttribute(classCode, dictItemMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
