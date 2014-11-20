package com.iidooo.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
    private static final Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;
    
    public List<CmsContentDto> getCmsContents(String channelPath, String tag, String orderBy, String count) {
        // TODO Auto-generated method stub
        return null;
    }
}
