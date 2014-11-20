package com.iidooo.cms.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.constant.SpringConstant;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.extend.DictClassDto;
import com.iidooo.framework.dto.extend.DictItemDto;
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
            DictItemDao dictItemDao = (DictItemDao) SpringUtil.getBean(sc, SpringConstant.BEAN_DICT_ITEM_DAO);
            DictClassDto dictClassDto = new DictClassDto();
            dictClassDto.setDictTypeCode(DictConstant.DICT_TYPE_SYSTEM_PROPERTIES);
            dictClassDto.setDictClassCode(DictConstant.DICT_CLASS_PROPERTIES_SITE);
            List<DictItemDto> dictItems = dictItemDao.selectByDictClass(dictClassDto);

            for (DictItemDto dictItemDto : dictItems) {
                String dictItemCode = dictItemDto.getDictItemCode();
                String dictItemValue = dictItemDto.getDictItemValue();
                if (DictConstant.DICT_ITEM_SITE_ADDRESS.equals(dictItemCode)) {
                    sc.setAttribute(AttributeConstant.SESSION_SITE_URL, dictItemValue);
                } else if (DictConstant.DICT_ITEM_SITE_RES_ROOT.equals(dictItemCode)) {
                    sc.setAttribute(AttributeConstant.SESSION_SITE_RES_ROOT, dictItemValue);
                } else if (DictConstant.DICT_ITEM_CONTENT_RES_ROOT.equals(dictItemCode)) {
                    sc.setAttribute(AttributeConstant.SESSION_CONTENT_RES_ROOT, dictItemValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
