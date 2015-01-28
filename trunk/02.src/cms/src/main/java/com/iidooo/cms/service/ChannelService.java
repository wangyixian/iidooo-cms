package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.tag.TreeNode;

public interface ChannelService {

    TreeNode getRootTree(String rootName, String baseURL);
    
    TreeNode getRootTree(String rootName, String baseURLList, String baseURLDetail);
    
    /**
     * Get all of the channels
     * @return The list of all of channels
     */
    List<CmsChannelDto> getAllChannels();
    
    /**
     * Get all of the offspring channels.
     * @param parentID This parent's offspring channels.
     * @param containSelf Weather contain itself.
     * @return The list of offspring channels.
     */
    List<CmsChannelDto> getOffspringChannels(int parentID, boolean containSelf);
    
    /**
     * Get channel by primary id
     * @param channelID The channel id to get the channel.
     * @return The gotten channel.
     */
    CmsChannelDto getChannelByID(int channelID);
    
    /**
     * Get channel by the path
     * @param channelPath This channel path's channel will be gotten.
     * @return The gotten channel.
     */
    CmsChannelDto getChannelByPath(String channelPath);
}
