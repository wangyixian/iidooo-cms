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
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.UserDto;
import com.opensymphony.xwork2.ActionContext;

@Service
public class ContentDetailService implements IContentDetailService {

    private static final Logger logger = Logger.getLogger(ContentDetailService.class);

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private ContentProductDao contentProductDao;

    @Override
    public ContentDto getContentByID(Integer contentID) {
        try {
            ContentDto result = contentDao.selectByContentID(contentID);
            if (result == null) {
                return null;
            }
            switch (result.getContentType()) {
            case CmsConstant.DICT_ITEM_CONTENT_TYPE_PRODUCT:
                result = contentProductDao.selectByContentID(contentID);
                break;

            default:
                break;
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
            UserDto user = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            content.setCreateUser(user.getUserID());
            content.setCreateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));
            content.setUpdateUser(user.getUserID());
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
            if (!this.createContent(content)) {
                return false;
            }

            product.setContentID(content.getContentID());
            int result = contentProductDao.insert(product);
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
    public boolean updateContent(ContentDto content) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            UserDto user = (UserDto) sessionMap.get(PassportConstant.LOGIN_USER);
            content.setUpdateUser(user.getUserID());
            content.setUpdateTime(DateUtil.getNow(DateUtil.FORMAT_DATETIME));

            int result = contentDao.update(content);
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
    public boolean updateContent(ContentDto content, ContentProductDto product) {
        try {
            if (!this.updateContent(content)) {
                return false;
            }

            product.setContentID(content.getContentID());
            int result = contentProductDao.updateByPrimaryKey(product);
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

}
