package com.iidooo.cms.service.content;

import java.util.List;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.dto.PageDto;

public interface ContentListService {

    ContentDto getContent(Integer contentID);
    
    int getContentListCount(Integer siteID, Integer channelID);

    List<ContentDto> getContentList(Integer siteID, Integer channelID, PageDto page);

    boolean deleteContent(ContentDto content);
}
