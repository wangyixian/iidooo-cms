package com.iidooo.cms.admin.action.channel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.channel.ChannelListService;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.tag.TreeNode;
import com.iidooo.framework.utility.StringUtil;

public class ChannelListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelListService channelListService;

    private List<CmsChannelDto> channelList;

    // The channel ID that selected on tree
    private int channelID = 0;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    public List<CmsChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<CmsChannelDto> channelList) {
        this.channelList = channelList;
    }

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public String init() {
        try {

            // Build the channel tree' root node.
            String rootName = this.getText("LABEL_TREE_ROOT");
            rootTreeNode = channelService.getRootTree(rootName, URLConstant.CHANNEL_LIST_INIT, URLConstant.CHANNEL_DETAIL_INIT);

            channelList = new ArrayList<CmsChannelDto>();
            List<CmsChannelDto> allChannels = channelService.getAllChannels();
            for (CmsChannelDto channel : allChannels) {

                if (channel.getParentID() == this.channelID) {
                    channelList.add(channel);
                }
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
