package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.framework.tag.component.TreeNode;

public interface IChannelService {

    TreeNode getRootTree(String rootName, String baseURL);
    
    TreeNode getRootTree(String rootName, String baseURLList, String baseURLDetail);
    
    /**
     * Get all of the channels
     * @return The list of all of channels
     */
    List<ChannelDto> getAllChannels();
    
    /**
     * Get all of the offspring channels.
     * @param parentID This parent's offspring channels.
     * @param containSelf Weather contain itself.
     * @return The list of offspring channels.
     */
    List<ChannelDto> getOffspringChannels(int parentID, boolean containSelf);
    
    /**
     * Get channel by primary id
     * @param channelID The channel id to get the channel.
     * @return The gotten channel.
     */
    ChannelDto getChannelByID(int channelID);
    
    List<ChannelDto> getChildrenChannels(int parentID);
    
    /**
     * Get channel by the path
     * @param channelPath This channel path's channel will be gotten.
     * @return The gotten channel.
     */
    ChannelDto getChannelByPath(String channelPath);
    
    /**
     * Delete the channel
     * @param channel This channel should be delete.
     * @return Delete success or not.
     */
    boolean deleteChannel(ChannelDto channel);
    
    ChannelDto exclusiveCheck(int channelID, int version);
}
