package com.iidooo.cms.admin.service.channel;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface ChannelListService {
    List<CmsChannelDto> getChannelList(int parentID);
}
