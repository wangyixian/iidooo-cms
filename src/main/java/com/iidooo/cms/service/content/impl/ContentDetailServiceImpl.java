package com.iidooo.cms.service.content.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.ContentDetailService;
import com.iidooo.core.constant.DateTimeFormat;
import com.iidooo.core.constant.SessionConstant;
import com.iidooo.core.dto.extend.SecurityUserDto;
import com.iidooo.core.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;

public class ContentDetailServiceImpl implements ContentDetailService {

    private static final Logger logger = Logger.getLogger(ContentDetailServiceImpl.class);

    private ContentDao contentDao;


    @Override
    public ContentDto getContentByID(Integer contentID) {
        try {
            ContentDto result = contentDao.selectByContentID(contentID);
            if (result == null) {
                return null;
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
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            content.setCreateUser(user.getUserID());
            content.setCreateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));
            content.setUpdateUser(user.getUserID());
            content.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

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
    public boolean updateContent(ContentDto content) {
        try {
            Map<String, Object> sessionMap = ActionContext.getContext().getSession();
            SecurityUserDto user = (SecurityUserDto) sessionMap.get(SessionConstant.LOGIN_USER);
            content.setUpdateUser(user.getUserID());
            content.setUpdateTime(DateUtil.getNow(DateTimeFormat.DATE_TIME_HYPHEN));

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
}
