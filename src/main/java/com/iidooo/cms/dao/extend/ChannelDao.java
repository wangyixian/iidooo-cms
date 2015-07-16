package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelDao {

    /**
     * Select all of the channels with the site code and channel level
     * @param siteCode The site code should be defined.
     * @return The list of channels
     */
    List<ChannelDto> selectBySiteCode(@Param("siteCode")String siteCode);

    List<ChannelDto> selectChannelChildren(@Param("siteCode")String siteCode, @Param("parentPath")String parentPath);    
    
    /**
     * Get the channel list by the record of ChannelDto
     * 
     * @param channel The channel record
     * @return The list of CmsChannelDto
     */
    List<ChannelDto> selectChannelList(ChannelDto channel);

    int selectMaxSequence(int parentID);
    
    /**
     * Get the channel by channel path
     * @param siteCode This site's channel will be gotten
     * @param channelPath The channel path
     * @return The ChannelDto gotten from DB.
     */
    ChannelDto selectChannelByPath(@Param("siteCode")String siteCode, @Param("channelPath")String channelPath);

    ChannelDto selectByChannelID(int channelID);

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
}
