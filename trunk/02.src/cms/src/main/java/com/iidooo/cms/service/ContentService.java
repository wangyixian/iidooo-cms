package com.iidooo.cms.service;

import com.iidooo.cms.dto.extend.CmsContentDto;

public interface ContentService {

    /**
     * Get the content by primary key.
     * @param contentID The content id as a primary key to get a content object.
     * @return The gotten content.
     */
    CmsContentDto getContentByID(int contentID);
    
    int getMaxSequence();
}
