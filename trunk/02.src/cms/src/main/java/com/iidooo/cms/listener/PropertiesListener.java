package com.iidooo.cms.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.constant.SpringConstant;
import com.iidooo.framework.dao.extend.DictItemDao;
import com.iidooo.framework.dto.extend.DictItemDto;
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

            // Set the site's properties into the ServletContext
            DictItemDao dictItemDao = (DictItemDao) SpringUtil.getBean(sc, SpringConstant.DICT_ITEM_DAO);
            
            List<DictItemDto> dictItems = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_PROPERTIES_SITE);
            for (DictItemDto dictItemDto : dictItems) {
                String dictItemCode = dictItemDto.getDictItemCode();
                String dictItemValue = dictItemDto.getDictItemValue();
                sc.setAttribute(dictItemCode, dictItemValue);
            }
            
            // Set the ContentTypeMap into the ServletContext
            List<DictItemDto> contentTypeList = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_CONTENT_TYPE);
            sc.setAttribute(AttributeConstant.CONTENT_TYPE_LIST, contentTypeList);
            // Set the contentTypeItems
            Map<Integer, String> contentTypeMap = new HashMap<Integer, String>();
            for (DictItemDto item : contentTypeList) {
                contentTypeMap.put(Integer.parseInt(item.getDictItemCode()), item.getDictItemValue());
            }
            sc.setAttribute(AttributeConstant.CONTENT_TYPE_MAP, contentTypeMap);
//
//            dictItems = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_TAG_COMIC_STATUS);
//            for (DictItemDto dictItemDto : dictItems) {
//                String dictItemCode = dictItemDto.getDictItemCode();
//                String dictItemValue = dictItemDto.getDictItemValue();
//                sc.setAttribute(DictConstant.DICT_CLASS_TAG_COMIC_STATUS + "_" + dictItemCode, dictItemValue);
//            }
//
//            dictItems = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_TAG_COMIC_TYPE);
//            for (DictItemDto dictItemDto : dictItems) {
//                String dictItemCode = dictItemDto.getDictItemCode();
//                String dictItemValue = dictItemDto.getDictItemValue();
//                sc.setAttribute(DictConstant.DICT_CLASS_TAG_COMIC_TYPE + "_" + dictItemCode, dictItemValue);
//            }
//
//            dictItems = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_TAG_LETTER);
//            for (DictItemDto dictItemDto : dictItems) {
//                String dictItemCode = dictItemDto.getDictItemCode();
//                String dictItemValue = dictItemDto.getDictItemValue();
//                sc.setAttribute(DictConstant.DICT_CLASS_TAG_LETTER + "_" + dictItemCode, dictItemValue);
//            }
//
//            dictItems = dictItemDao.selectByClassCode(DictConstant.DICT_CLASS_TAG_COUNTRY);
//            for (DictItemDto dictItemDto : dictItems) {
//                String dictItemCode = dictItemDto.getDictItemCode();
//                String dictItemValue = dictItemDto.getDictItemValue();
//                sc.setAttribute(DictConstant.DICT_CLASS_TAG_COUNTRY + "_" + dictItemCode, dictItemValue);
//            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
