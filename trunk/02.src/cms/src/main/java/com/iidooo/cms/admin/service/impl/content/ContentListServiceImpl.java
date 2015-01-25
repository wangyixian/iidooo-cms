package com.iidooo.cms.admin.service.impl.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.content.ContentListService;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ContentListServiceImpl implements ContentListService {

    private static final Logger logger = Logger.getLogger(ContentListServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

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
