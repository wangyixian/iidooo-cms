package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.framework.tag.component.TreeNode;

public interface IChannelService {

    TreeNode getRootTree(String rootName, String baseURL);
    
    TreeNode getRootTree(String rootName, String baseURLList, String baseURLDetail);
    

    
    /**
     * Get all of the offspring channels.
     * @param parentID This parent's offspring channels.
     * @param containSelf Weather contain itself.
     * @return The list of offspring channels.
     */
    List<ChannelDto> getOffspringChannels(int parentID, boolean containSelf);
    

    
    List<ChannelDto> getChildrenChannels(int parentID);
    
}
