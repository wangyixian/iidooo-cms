package com.iidooo.cms.service.content;

import com.iidooo.cms.dto.extend.ContentDto;

public interface ContentDetailService {
    ContentDto getContentByID(Integer contentID);
    
    boolean createContent(ContentDto content);
    
    boolean updateContent(ContentDto content);
}
