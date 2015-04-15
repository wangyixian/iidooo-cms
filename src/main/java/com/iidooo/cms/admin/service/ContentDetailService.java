package com.iidooo.cms.admin.service;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;

public interface ContentDetailService {
    boolean createContent(ContentDto content);

    boolean createContent(ContentDto content, ContentProductDto product);

    boolean createContent(ContentDto content, CmsContentArticleDto article);

    boolean updateContent(ContentDto content);

    boolean updateContent(ContentDto content, ContentProductDto product);

    boolean updateContent(ContentDto content, CmsContentArticleDto article);

    
}
