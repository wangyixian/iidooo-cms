package com.iidooo.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.constant.SpringConstant;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.generate.DictItem;
import com.iidooo.framework.utility.SpringUtil;

public class PropertiesListener extends HttpServlet implements ServletContextListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(PropertiesListener.class);
    
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            
            // 得到站点的配置信息
            DictItemDao dictItemDao = (DictItemDao)SpringUtil.getBean(sc, SpringConstant.BEAN_DICT_ITEM_DAO);
            DictItem dictItem = dictItemDao.selectByItemCode(DictConstant.DICT_ITEM_SITE_ADDRESS);
            sc.setAttribute(AttributeConstant.SITE_ADDRESS, dictItem.getDictItemValue());            
            
        } catch (Exception e) {
            logger.fatal(e);
        }
    }
}
