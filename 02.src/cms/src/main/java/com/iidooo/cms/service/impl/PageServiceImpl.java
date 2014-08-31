package com.iidooo.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsBlockDao;
import com.iidooo.cms.dao.extend.CmsPageDao;
import com.iidooo.cms.dto.generate.CmsBlock;
import com.iidooo.cms.dto.generate.CmsPage;
import com.iidooo.cms.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    private static final Logger logger = Logger.getLogger(PageServiceImpl.class);

    @Autowired
    private CmsPageDao cmsPageDao;
    
    @Autowired
    private CmsBlockDao cmsBlockDao;

    public CmsPage getPageByName(String pageName) {
        CmsPage cmsPage = null;
        try {
            cmsPage = cmsPageDao.selectByPageName(pageName);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return cmsPage;
    }

    public HashMap<String, CmsBlock> getBlockMap(int pageID) {
        HashMap<String, CmsBlock> blockMap = new HashMap<String, CmsBlock>();
        try {
            List<CmsBlock> blockList = cmsBlockDao.selectByPageID(pageID);
            for (CmsBlock cmsBlock : blockList) {
                blockMap.put(cmsBlock.getBlockName(), cmsBlock);
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return blockMap;
    }
}
