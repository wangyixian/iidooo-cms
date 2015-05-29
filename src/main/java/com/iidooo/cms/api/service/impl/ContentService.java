package com.iidooo.cms.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.api.service.IContentService;
import com.iidooo.cms.dao.extend.ContentDao;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

@Service
public class ContentService implements IContentService {

    private static final Logger logger = Logger.getLogger(ContentService.class);

    @Autowired
    private ContentDao contentDao;

    @Override
    public ContentDto getContent(int contentID) {
        try {
            ContentDto result  = null;
            result = contentDao.selectByContentID(contentID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public List<ContentDto> getContentList(String siteCode, String channelPath, PageDto page) {
        List<ContentDto> result = new ArrayList<ContentDto>();
        try {
            result = contentDao.selectByChannelPath(siteCode, channelPath, page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }
}
