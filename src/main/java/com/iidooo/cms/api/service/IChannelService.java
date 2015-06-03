package com.iidooo.cms.api.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface IChannelService {
    List<ChannelDto> getChannelList(String siteCode, int channelLevel);
    
    
    /**
     * Get the channel list that is displayed.
     * IsHidden = 0
     * @param siteCode The field of site code
     * @param channelLevel The level of channel will be gotten.
     * @return The list of channel DTO
     */
    List<ChannelDto> getDisplayChannelList(String siteCode, int channelLevel);
    
    ChannelDto getChannel(String siteCode, String channelPath);
}
