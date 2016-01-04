package com.iidooo.cms.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelListService {
    
    /**
     * 获得父栏目的所有子栏目
     * @param parentID 父栏目的ID
     * @return 该父栏目下的子栏目对象列表
     */
    List<ChannelDto> getChildrenChannelList(int parentID);
    
    ChannelDto getChannel(int channelID);
    
    boolean hasChildren(int parentID);
    
    
    /**
     * Delete the channel
     * 
     * @param channel This channel should be delete.
     * @return Delete success or not.
     */
    boolean deleteChannel(ChannelDto channel);
}
