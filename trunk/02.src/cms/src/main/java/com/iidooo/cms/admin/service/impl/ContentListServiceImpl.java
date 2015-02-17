package com.iidooo.cms.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.admin.service.ContentListService;
import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ContentListServiceImpl implements ContentListService {

    private static final Logger logger = Logger.getLogger(ContentListServiceImpl.class);

    @Autowired
    private CmsContentDao cmsContentDao;

}
