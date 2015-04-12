package com.iidooo.cms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentArticleDao;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.service.ContentArticleService;

@Service
public class ContentArticleServiceImpl implements ContentArticleService{
    
    private static final Logger logger = Logger.getLogger(ContentArticleServiceImpl.class);
    
    @Autowired
    private CmsContentArticleDao cmsContentArticleDao;
    
    @Override
    public CmsContentArticleDto getContentByID(int contentID) {
        try {
            CmsContentArticleDto result = cmsContentArticleDao.selectByContentID(contentID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
