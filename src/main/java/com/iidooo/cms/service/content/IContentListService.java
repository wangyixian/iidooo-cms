package com.iidooo.cms.service.content;

import java.util.List;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

public interface IContentListService {
    
    int getContentListCount(Integer channelID);
    
    List<ContentDto> getContentList(Integer channelID, PageDto page);
    
    boolean deleteContent(ContentDto content);
}
