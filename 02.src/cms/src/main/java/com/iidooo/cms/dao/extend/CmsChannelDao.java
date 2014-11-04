package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface CmsChannelDao {
    List<CmsChannelDto> selectAllChannels();
    
    CmsChannelDto selectChannelByPath(String channelPath);
}
