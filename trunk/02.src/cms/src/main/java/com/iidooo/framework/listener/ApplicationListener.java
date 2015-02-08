package com.iidooo.framework.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.enumeration.BeanName;
import com.iidooo.framework.utility.SpringUtil;

public class ApplicationListener extends HttpServlet implements ServletContextListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ApplicationListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            DictItemDao dictItemDao = (DictItemDao) SpringUtil.getBean(sc, BeanName.dictItemDao);
            DictItemDto dictItemDto = dictItemDao.selectByItemCode(DictConstant.DICT_ITEM_PAGE_SIZE);
            
            // 把分页值放入Application作用域的Map中，转成Integer存入，取出时不用再耗费资源转换
            sc.setAttribute(DictConstant.DICT_ITEM_PAGE_SIZE, Integer.parseInt(dictItemDto.getDictItemValue()));
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
