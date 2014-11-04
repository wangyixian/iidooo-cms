package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface ChannelService {
    CmsChannelDto getChannelByPath(String channelPath);
    
    List<CmsChannelDto> getAllChannels();
}
