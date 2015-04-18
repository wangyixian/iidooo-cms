package com.iidooo.cms.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.dto.PageDto;

public interface IChannelListService {

    List<ChannelDto> getChildrenChannelList(int parentID);

    /**
     * Delete the channel
     * 
     * @param channel This channel should be delete.
     * @return Delete success or not.
     */
    boolean deleteChannel(ChannelDto channel);
}
