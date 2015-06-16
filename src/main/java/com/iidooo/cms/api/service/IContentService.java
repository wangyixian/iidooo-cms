package com.iidooo.cms.api.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

public interface IContentService {
    
    ContentDto getContent(int contentID);
    
    ContentDto getContent(String siteCode, String channelPath);
    
    int getContentListSize(String siteCode, String channelPath);
    
    List<ContentDto> getContentList(String siteCode, String channelPath, PageDto page);
}
