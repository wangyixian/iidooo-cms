package com.iidooo.cms.admin.service.impl.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.content.ContentListService;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ContentListServiceImpl implements ContentListService {

    private static final Logger logger = Logger.getLogger(ContentListServiceImpl.class);
    
    @Autowired
    private CmsContentDao cmsContentDao;
    
    @Override
    public List<CmsContentDto> getAllContents(PagingDto pagingDto) {
        try {
            List<CmsContentDto> contentList = null;
            contentList = cmsContentDao.selectAll(pagingDto);
            return contentList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public int getAllContentsCount() {
        try {
            int recordSum = cmsContentDao.selectAllCount();
            return recordSum;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

}
