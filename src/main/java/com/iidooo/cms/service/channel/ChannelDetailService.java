package com.iidooo.cms.service.channel;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelDetailService {

    /**
     * 通过ChannelID获得栏目对象
     * 
     * @param channelID
     * @return 所获得的ChannelDto对象
     */
    ChannelDto getChannelByID(int channelID);

    /**
     * 通过ChannelPath获得栏目对象
     * 
     * @param channelPath
     * @return 所获得的ChannelDto对象
     */
    ChannelDto getChannelByPath(String channelPath);

    boolean createChannel(ChannelDto channel);

    boolean updateChannel(ChannelDto channel);
}
