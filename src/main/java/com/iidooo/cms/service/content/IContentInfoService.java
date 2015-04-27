package com.iidooo.cms.service.content;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;

public interface IContentInfoService {
    ContentDto getContentByID(ContentDto content);
    
    boolean createContent(ContentDto content);
    
    boolean createContent(ContentDto content, ContentProductDto product);
    
    boolean updateContent(ContentDto content);
    
    boolean updateContent(ContentDto content, ContentProductDto product);
}
