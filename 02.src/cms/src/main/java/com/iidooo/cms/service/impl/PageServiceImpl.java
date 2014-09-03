package com.iidooo.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsBlockDao;
import com.iidooo.cms.dao.extend.CmsLinkDao;
import com.iidooo.cms.dao.extend.CmsPageDao;
import com.iidooo.cms.dto.extend.CmsBlockDto;
import com.iidooo.cms.dto.extend.CmsLinkDto;
import com.iidooo.cms.dto.generate.CmsPage;
import com.iidooo.cms.service.PageService;
import com.iidooo.framework.dao.extend.DictItemDao;

@Service
public class PageServiceImpl implements PageService {

    private static final Logger logger = Logger.getLogger(PageServiceImpl.class);

    @Autowired
    private CmsPageDao cmsPageDao;

    @Autowired
    private CmsBlockDao cmsBlockDao;

    @Autowired
    private CmsLinkDao cmsLinkDao;

    @Autowired
    private DictItemDao dictItemDao;

    public CmsPage getPageByName(String pageName) {
        CmsPage cmsPage = null;
        try {
            cmsPage = cmsPageDao.selectByPageName(pageName);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return cmsPage;
    }

    public HashMap<String, CmsBlockDto> getBlockMap(int pageID) {
        HashMap<String, CmsBlockDto> blockMap = new HashMap<String, CmsBlockDto>();
        try {
            List<CmsBlockDto> blockList = cmsBlockDao.selectByPageID(pageID);
            for (CmsBlockDto cmsBlock : blockList) {
                List<CmsLinkDto> cmsLinks = cmsLinkDao.selectByBlockID(cmsBlock.getBlockID());
                cmsBlock.setCmsLinks(cmsLinks);
                blockMap.put(cmsBlock.getBlockName(), cmsBlock);
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return blockMap;
    }

}
