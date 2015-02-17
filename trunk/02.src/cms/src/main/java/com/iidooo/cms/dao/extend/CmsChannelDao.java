package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public interface CmsChannelDao {
    
    /**
     * Select all of the channels
     * @return The list of channels
     */
    List<CmsChannelDto> selectAll();

    /**
     * Get the channel list by the parent ID
     * 
     * @param parentID The parent ID for get the channel list
     * @return The list of CmsChannelDto
     */
    List<CmsChannelDto> selectByParentID(int parentID);

    CmsChannelDto selectChannelByPath(String channelPath);

    CmsChannelDto selectChannelByID(int channelID);

    /**
     * 插入一个新的栏目
     * @param channel 该栏目的信息会被插入
     * @return 返回执行结果，即影响到的行数
     */
    int insert(CmsChannelDto channel);
    
    /**
     * 更新一个栏目
     * @param channel 该栏目的信息会被更新
     * @return 返回执行结果，即影响到的行数
     */
    int update(CmsChannelDto channel);
    
    /**
     * Logic delete the channel, set the IsDelete = 1
     * @param channel This channel will be delete
     * @return The deleted channel count
     */
    int deleteByPrimaryKey(CmsChannelDto channel);

    /**
     * Exclusive check
     * @param channelID channelID
     * @param version The channel version
     * @return The channel dto
     */
    CmsChannelDto exclusiveCheck(int channelID, int version);
}
