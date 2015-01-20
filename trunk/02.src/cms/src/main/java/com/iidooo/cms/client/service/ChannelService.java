package com.iidooo.cms.client.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface ChannelService {
    CmsChannelDto getChannelByPath(String channelPath);
    
    CmsChannelDto getChannelByID(int channelID);
    
    List<CmsChannelDto> getAllChannels();
}
