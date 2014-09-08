package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dao.extend.CmsBlockDao;
import com.iidooo.cms.dao.extend.CmsLinkDao;
import com.iidooo.cms.dao.extend.CmsPageDao;
import com.iidooo.cms.dto.extend.CmsBlockDto;
import com.iidooo.cms.dto.extend.CmsLinkDto;
import com.iidooo.cms.dto.extend.CmsPageDto;
import com.iidooo.cms.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    private static final Logger logger = Logger.getLogger(PageServiceImpl.class);

    @Autowired
    private CmsPageDao cmsPageDao;

    @Autowired
    private CmsBlockDao cmsBlockDao;

    @Autowired
    private CmsLinkDao cmsLinkDao;

    public CmsPageDto getPageByID(int pageID) {
        CmsPageDto cmsPage = null;
        try {
            cmsPage = cmsPageDao.selectByPageID(pageID);
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
                for (CmsLinkDto cmsLinkDto : cmsLinks) {
                    if (cmsLinkDto.getLinkPageID() != 0) {
                        cmsLinkDto.setLinkURL(AttributeConstant.LINK_URL.replace("{1}", cmsLinkDto.getLinkPageID().toString()));                        
                    }
                    cmsLinkDto.setSubringPageIDs(getSubringLinks(cmsLinkDto));
                }
                cmsBlock.setCmsLinks(cmsLinks);
                blockMap.put(cmsBlock.getBlockCode(), cmsBlock);
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return blockMap;
    }

    private List<Integer> getSubringLinks(CmsLinkDto parentLink) {
        List<Integer> subringLinks = new ArrayList<Integer>();
        List<CmsLinkDto> childrenLinks = cmsLinkDao.selectByParentLinkID(parentLink.getLinkID());
        for (CmsLinkDto cmsLinkDto : childrenLinks) {
            if (!subringLinks.contains(cmsLinkDto.getLinkID())) {
                subringLinks.add(cmsLinkDto.getLinkID());
            }
        }

        for (CmsLinkDto childLink : childrenLinks) {
            subringLinks.addAll(getSubringLinks(childLink));
        }
        return subringLinks;
    }
}
