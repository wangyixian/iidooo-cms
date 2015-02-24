package com.iidooo.cms.client.service.blog;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface BlogListService {
    
    int getArticlesCount(int channelID);
    
    List<CmsContentArticleDto> getArticles(int channelID, PagingDto page);
}
