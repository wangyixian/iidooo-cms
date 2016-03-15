package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ContentService;
import com.iidooo.core.model.Page;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    @Override
    public List<CmsContentDto> getContentListByType(String channelPath, String contentType, Page page) {
        try {
            List<CmsContentDto> result = new ArrayList<CmsContentDto>();

            result = cmsContentDao.selectContentListByType(channelPath, contentType, page);

            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

}
