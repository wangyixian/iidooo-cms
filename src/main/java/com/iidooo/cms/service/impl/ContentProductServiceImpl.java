package com.iidooo.cms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ContentProductDao;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.ContentProductService;

@Service
public class ContentProductServiceImpl implements ContentProductService {

    private static final Logger logger = Logger.getLogger(ContentProductServiceImpl.class);

    @Autowired
    private ContentProductDao cmsContentProductDao;

    @Override
    public ContentProductDto getContentByID(int contentID) {
        try {
            ContentProductDto result = cmsContentProductDao.selectByContentID(contentID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

}
