package com.iidooo.cms.service;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;

public interface ContentArticleService {
    CmsContentArticleDto getContentByID(int contentID);
}
