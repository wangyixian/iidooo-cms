package com.iidooo.cms.admin.service;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;

public interface ContentDetailService {
    boolean createContent(CmsContentDto content);

    boolean createContent(CmsContentDto content, CmsContentProductDto product);

    boolean createContent(CmsContentDto content, CmsContentArticleDto article);

    boolean updateContent(CmsContentDto content);

    boolean updateContent(CmsContentDto content, CmsContentProductDto product);

    boolean updateContent(CmsContentDto content, CmsContentArticleDto article);

    
}
