package com.iidooo.cms.service.channel;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface IChannelInfoService {
    
    /**
     * Get channel by primary id
     * @param channelID The channel id to get the channel.
     * @return The gotten channel.
     */
    ChannelDto getChannelByID(int channelID);
}
