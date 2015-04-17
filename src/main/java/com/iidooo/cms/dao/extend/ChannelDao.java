package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelDao {
    
    /**
     * Select all of the channels
     * @return The list of channels
     */
    List<ChannelDto> selectAll();

    /**
     * Get the channel list by the parent ID
     * 
     * @param parentID The parent ID for get the channel list
     * @return The list of CmsChannelDto
     */
    List<ChannelDto> selectByParentID(int parentID);

    ChannelDto selectChannelByPath(String channelPath);

    ChannelDto selectChannelByID(int channelID);

    /**
     * Insert a new ChannelDto into the database
     * @param channel This ChannelDto should be inserted.
     * @return The affected record number.
     */
    int insert(ChannelDto channel);
    
    /**
     * Update a channel by the ChannelDto
     * @param channel This ChannelDto will updated.
     * @return The affected record number.
     */
    int update(ChannelDto channel);
    
    /**
     * Logic delete the channel, set the IsDelete = 1
     * @param channel This channel will be delete
     * @return The deleted channel count
     */
    int deleteByPrimaryKey(ChannelDto channel);

    /**
     * Exclusive check
     * @param channelID channelID
     * @param version The channel version
     * @return The channel dto
     */
    ChannelDto exclusiveCheck(int channelID, int version);
}
