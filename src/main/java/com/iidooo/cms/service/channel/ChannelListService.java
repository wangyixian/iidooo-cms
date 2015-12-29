package com.iidooo.cms.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelListService {
    
    ChannelDto getChannel(int channelID);
    
    boolean hasChildren(int parentID);
    
    List<ChannelDto> getChildrenChannelList(int parentID);
    
    /**
     * Delete the channel
     * 
     * @param channel This channel should be delete.
     * @return Delete success or not.
     */
    boolean deleteChannel(ChannelDto channel);
}
