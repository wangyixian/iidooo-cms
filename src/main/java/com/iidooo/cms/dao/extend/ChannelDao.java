package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelDao {

    /**
     * 通过ParentID获得栏目一览
     * 
     * @param parentID ParentID即父栏目的ID
     * @return ChannelDto的List
     */
    List<ChannelDto> selectByParentID(int parentID);

    /**
     * 通过ParentID获得栏目一览的个数
     * @param parentID ParentID即父栏目的ID
     * @return 子栏目的个数
     */
    int selectCountByParentID(int parentID);
    
    /**
     * 通过Channel ID获得栏目对象
     * @param channelID 主键
     * @return 所获得栏目对象
     */
    ChannelDto selectByChannelID(int channelID);
    
    /**
     * 通过Channel Path 获得栏目对象
     * 
     * @param 通过该Channel Path 获得栏目对象
     * @return 所获得栏目对象
     */
    ChannelDto selectByChannelPath(String channelPath);
    
    /**
     * 获得所有的栏目
     * @return 所有的栏目
     */
    List<ChannelDto> selectAllChannels();
    
    List<ChannelDto> selectChannelChildren(@Param("siteCode") String siteCode, @Param("parentPath") String parentPath);


    /**
     * Get the channel list by the record of ChannelDto
     * 
     * @param channel The channel record
     * @return The list of CmsChannelDto
     */
    List<ChannelDto> selectChannelList(ChannelDto channel);

    /**
     * 获得同一个ParentID下的最大Sequence
     * 
     * @param parentID 该ParentID下的所有子栏目
     * @return 最大的Sequence
     */
    Integer selectMaxSequence(int parentID);   

    /**
     * 添加一个新的栏目
     * 
     * @param channel 要被添加的栏目对象
     * @return 受影响的行数
     */
    int insert(ChannelDto channel);

    /**
     * 更新一个栏目对象
     * 
     * @param channel 该栏目对象会被更新
     * @return 受影响的行数
     */
    int update(ChannelDto channel);

    /**
     * 根据ChannelID逻辑删除一个栏目对象
     * 
     * @param channel 该栏目对象会被删除
     * @return 受影响的行数
     */
    int deleteByChannelID(ChannelDto channel);
}
