package com.iidooo.cms.api.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.api.service.ISiteService;
import com.iidooo.cms.dao.extend.SiteDao;
import com.iidooo.cms.dto.extend.CommentDto;

@Service
public class SiteService implements ISiteService {
    
    private static final Logger logger = Logger.getLogger(SiteService.class);

    @Autowired
    private SiteDao siteDao;
    
    @Override
    public CommentDto getSite(String siteCode) {
        try {
            CommentDto result = siteDao.selectBySiteCode(siteCode);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
