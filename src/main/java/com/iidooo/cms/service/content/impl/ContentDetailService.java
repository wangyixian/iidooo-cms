package com.iidooo.cms.service.content.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dao.extend.ContentProductDao;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.content.IContentDetailService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.passport.filter.SSOFilter;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ContentDetailService implements IContentDetailService {

    private static final Logger logger = Logger.getLogger(ContentDetailService.class);

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private ContentProductDao contentProductDao;
    
    @Override
    public ContentDto getContentByID(ContentDto content) {
        try {
            ContentDto result = null;
            if (content.getContentType().equals(CmsConstant.CONTENT_TYPE_DEFAULT)) {
                result = contentDao.selectByContentID(content.getContentID());
            } else if (content.getContentType().equals(CmsConstant.CONTENT_TYPE_PRODUCT)) {
                result = contentProductDao.selectByContentID(content.getContentID());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public boolean createContent(ContentDto content) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            int userID = (int) sessionMap.get(SSOFilter.USER_ID);
            content.setCreateUser(userID);
            content.setCreateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            content.setUpdateUser(userID);
            content.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            
            int result = contentDao.insert(content);
            if (result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean createContent(ContentDto content, ContentProductDto product) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean updateContent(ContentDto content) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

    @Override
    public boolean updateContent(ContentDto content, ContentProductDto product) {
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }

}
