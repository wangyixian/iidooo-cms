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
     * 根据栏目ID，逻辑删除一个栏目，即把该栏目的IsDelete设置为1
     * @param channelID 该栏目ID会被删除
     * @return 返回执行结果，即影响到的行数
     */
    int delete(int channelID);

    /**
     * 排他性检查，通过判断该Channel是否版本已变化过
     * @param channelID 检查的channelID
     * @param version 当前的版本
     * @return 返回的数量，等于0即没有找到，该版本变动过
     */
    int exclusiveCheck(int channelID, int version);
}
