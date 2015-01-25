package com.iidooo.cms.admin.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface ChannelListService {
    List<CmsChannelDto> getChannelList(int parentID);
       
    /**
     * Delete the channel
     * @param channel This channel should be delete.
     * @return Delete success or not.
     * @throws Exception This exception will be throw when exception happened.
     */
    boolean deleteChannel(CmsChannelDto channel) throws Exception;;
}
