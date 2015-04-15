package com.iidooo.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dao.extend.CmsContentTagDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.CmsContentTagDto;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private ContentDao cmsContentDao;

    @Autowired
    private CmsContentTagDao cmsTagDao;

    @Override
    public ContentDto getContentByID(int contentID) {
        try {
            ContentDto cmsContentDto = cmsContentDao.selectContentByID(contentID);

            // List<CmsContentTagDto> cmsTagDtos = cmsTagDao.selectTagsByContentID(contentID);
            // cmsContentDto.setTags(cmsTagDtos);

            return cmsContentDto;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public ContentDto getContentByChannel(int channelID) {
        try {
            ContentDto content = cmsContentDao.selectByChannel(channelID);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
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
    public int getChannelContentsCount(List<ChannelDto> channels) {
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
    public List<ContentDto> getChannelContents(List<ChannelDto> channels, PagingDto pagingDto) {
        try {
            List<ContentDto> contentList = cmsContentDao.selectChannelContents(channels, pagingDto);
            return contentList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
    
    @Override
    public boolean deleteContent(ContentDto content) {
        try {
            content.setCommonData(false);
            int sum =  cmsContentDao.deleteByPrimaryKey(content);
            if (sum <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return false;
        }
    }
}
