package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.impl.content.ContentListServiceImpl;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dao.extend.CmsContentTagDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentTagDto;
import com.iidooo.cms.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentListServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    @Autowired
    private CmsContentTagDao cmsTagDao;

    @Override
    public CmsContentDto getContentByID(int contentID) {
        try {
            CmsContentDto cmsContentDto = cmsContentDao.selectContentByID(contentID);

            List<CmsContentTagDto> cmsTagDtos = cmsTagDao.selectTagsByContentID(contentID);
            cmsContentDto.setTags(cmsTagDtos);

            return cmsContentDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
            throw e;
        }
    }

}
