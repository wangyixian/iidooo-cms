package com.iidooo.cms.admin.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface ChannelListService {
    List<CmsChannelDto> getChannelList(int parentID);
}
