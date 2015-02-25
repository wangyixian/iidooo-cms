package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ContentService {

    /**
     * Get the content by primary key.
     * 
     * @param contentID The content id as a primary key to get a content object.
     * @return The gotten content.
     */
    CmsContentDto getContentByID(int contentID);
    
    /**
     * Get the top one content of the channel, order by sequence.
     * @param channelID The channel's content will be gotten. 
     * @return The top one content.
     */
    CmsContentDto getContentByChannel(int channelID);

    int getChannelContentsCount(List<CmsChannelDto> channels);

    List<CmsContentDto> getChannelContents(List<CmsChannelDto> channels, PagingDto pagingDto);

    int getMaxSequence();
}