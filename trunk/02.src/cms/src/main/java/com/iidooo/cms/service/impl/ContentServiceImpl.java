package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dao.extend.CmsContentTagDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentTagDto;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.dto.base.PagingDto;

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

    @Override
    public int getChannelContentsCount(List<CmsChannelDto> channels) {
        try {
            int recordSum = cmsContentDao.selectChannelContentsCount(channels);            
            return recordSum;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public List<CmsContentDto> getChannelContents(List<CmsChannelDto> channels, PagingDto pagingDto) {
        try {
            List<CmsContentDto> contentList = cmsContentDao.selectChannelContents(channels, pagingDto);
            return contentList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
}
