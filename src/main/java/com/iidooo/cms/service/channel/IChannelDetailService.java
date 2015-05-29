package com.iidooo.cms.service.channel;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface IChannelDetailService {

    /**
     * Get channel by primary id
     * 
     * @param channelID The channel id to get the channel.
     * @return The gotten channel.
     */
    ChannelDto getChannelByID(int channelID);

    /**
     * Get channel by the path
     * 
     * @param channelPath This channel path's channel will be gotten.
     * @return The gotten channel.
     */
    ChannelDto getChannelByPath(String siteCode, String channelPath);

    boolean createChannel(ChannelDto channel);

    boolean updateChannel(ChannelDto channel);
}
