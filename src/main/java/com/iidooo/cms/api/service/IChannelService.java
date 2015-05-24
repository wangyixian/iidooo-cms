package com.iidooo.cms.api.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface IChannelService {
    List<ChannelDto> getChannelList(String siteCode);
}
