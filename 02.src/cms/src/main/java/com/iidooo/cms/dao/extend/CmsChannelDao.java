package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface CmsChannelDao {
    List<CmsChannelDto> selectAllChannels();

    /**
     * Get the channel list by the parent ID
     * 
     * @param parentID The parent ID for get the channel list
     * @return The list of CmsChannelDto
     */
    List<CmsChannelDto> selectChannelsByParentID(int parentID);

    List<CmsChannelDto> selectTopChannels(Map<String, Object> params);

    CmsChannelDto selectChannelByPath(String channelPath);

    CmsChannelDto selectChannelByID(int channelID);

    /**
     * Insert a new channel
     * @param channel The new channel
     * @return Insert result
     */
    int insert(CmsChannelDto channel);
}
