package com.iidooo.cms.service.channel;

import com.iidooo.cms.dto.extend.ChannelDto;

public interface ChannelDetailService {

    /**
     * 通过ChannelID获得栏目对象
     * 
     * @param channelID
     * @return 所获得的ChannelDto对象
     */
    ChannelDto getChannelByID(int channelID);

    /**
     * 通过ChannelPath获得栏目对象
     * 
     * @param channelPath
     * @return 所获得的ChannelDto对象
     */
    ChannelDto getChannelByPath(String channelPath);

    /**
     * 创建新的栏目
     * 
     * @param channel 该栏目对象会被创建
     * @return 创建成功或失败
     */
    boolean createChannel(ChannelDto channel);

    /**
     * 更新栏目
     * 
     * @param channel 该栏目对象会被更新
     * @return 更新成功或失败
     */
    boolean updateChannel(ChannelDto channel);
    

    boolean hasChildren(int parentID);
    
    
    /**
     * Delete the channel
     * 
     * @param channel This channel should be delete.
     * @return Delete success or not.
     */
    boolean deleteChannel(ChannelDto channel);
}
