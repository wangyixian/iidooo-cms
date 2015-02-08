package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dao.extend.CmsContentTagDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentTagDto;
import com.iidooo.cms.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

    @Autowired
    private CmsContentTagDao cmsTagDao;

    @Override
    public CmsContentDto getContentByID(int contentID) {
        try {
            CmsContentDto cmsContentDto = cmsContentDao.selectContentByID(contentID);

//            List<CmsContentTagDto> cmsTagDtos = cmsTagDao.selectTagsByContentID(contentID);
//            cmsContentDto.setTags(cmsTagDtos);

            return cmsContentDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
            throw e;
        }
    }

    @Override
    public int getMaxSequence() {
        try {
            int sequence = cmsContentDao.selectMaxSequence();
            return sequence;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return 0;
    }

}
