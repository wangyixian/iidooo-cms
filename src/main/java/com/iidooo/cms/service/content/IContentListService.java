package com.iidooo.cms.service.content;

import java.util.List;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

public interface IContentListService {
    List<ContentDto> getContentListByChannel(Integer channelID, PageDto page);
    
    boolean deleteContent(ContentDto content);
}
