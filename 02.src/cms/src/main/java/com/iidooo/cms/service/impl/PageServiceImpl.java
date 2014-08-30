package com.iidooo.cms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsPageDao;
import com.iidooo.cms.dto.generate.CmsPage;
import com.iidooo.cms.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    private static final Logger logger = Logger.getLogger(PageServiceImpl.class);
    
    @Autowired
    private CmsPageDao cmsPageDao;
    
    public CmsPage getPageByName(String pageName) {
        CmsPage cmsPage = null;
        try {
            cmsPage = cmsPageDao.selectByPageName(pageName);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return cmsPage;
    }
}
