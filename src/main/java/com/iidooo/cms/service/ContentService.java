package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ContentService {

    /**
     * Get the content by primary key.
     * 
     * @param contentID The content id as a primary key to get a content object.
     * @return The gotten content.
     */
    ContentDto getContentByID(int contentID);
    
    /**
     * Get the top one content of the channel, order by sequence.
     * @param channelID The channel's content will be gotten. 
     * @return The top one content.
     */
    ContentDto getContentByChannel(int channelID);

    int getChannelContentsCount(List<ChannelDto> channels);

    List<ContentDto> getChannelContents(List<ChannelDto> channels, PagingDto pagingDto);

    int getMaxSequence();
    
    boolean deleteContent(ContentDto content);
}
