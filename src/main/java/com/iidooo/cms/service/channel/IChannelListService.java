package com.iidooo.cms.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface IChannelListService {
    List<ChannelDto> searchChannelList(int parentID); 
}
