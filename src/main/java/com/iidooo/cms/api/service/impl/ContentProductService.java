package com.iidooo.cms.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.api.service.IContentProductService;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dao.extend.ContentProductDao;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.util.ChannelUtil;
import com.iidooo.core.dto.PageDto;

@Service
public class ContentProductService implements IContentProductService {

    private static final Logger logger = Logger.getLogger(ContentProductService.class);

    @Autowired
    private ChannelDao channelDao;
    
    @Autowired
    private ContentProductDao contentProductDao;

    @Override
    public ContentProductDto getContentProduct(int contentID) {
        try {
            ContentProductDto result = null;

            result = contentProductDao.selectByContentID(contentID);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }

    @Override
    public int searchContentProductListSize(String siteCode, ContentProductDto product) {
        try {
            ChannelUtil channelUtil = new ChannelUtil(channelDao);
            List<Integer> channels = channelUtil.getOffspringChannelIDList(siteCode, product.getChannelPath());
            int count = contentProductDao.selectProductListSize(siteCode, channels, product);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return 0;
        }
    }

    @Override
    public List<ContentProductDto> searchContentProductList(String siteCode, ContentProductDto product, PageDto page) {
        List<ContentProductDto> result = new ArrayList<ContentProductDto>();
        try {
            ChannelUtil channelUtil = new ChannelUtil(channelDao);
            List<Integer> channels = channelUtil.getOffspringChannelIDList(siteCode, product.getChannelPath());
            result = contentProductDao.selectProductList(siteCode, channels, product, page);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return result;
    }

}
