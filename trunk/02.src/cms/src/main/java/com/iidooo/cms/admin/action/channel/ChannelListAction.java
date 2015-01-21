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
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.exception.ExclusiveException;
import com.iidooo.framework.tag.TreeNode;
import com.iidooo.framework.utility.StringUtil;

public class ChannelListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

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
            rootTreeNode = new TreeNode();
            rootTreeNode.setUrl(StringUtil.replace(URLConstant.CHANNEL_LIST_INIT, "0"));
            rootTreeNode.setName(this.getText("LABEL_TREE_ROOT"));

            channelList = new ArrayList<CmsChannelDto>();
            List<CmsChannelDto> allChannels = channelListService.getAllChannelList();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (CmsChannelDto channel : allChannels) {
                // Build the tree node of the CmsChannelDto
                TreeNode treeNode = new TreeNode();
                treeNode.setUrl(StringUtil.replace(URLConstant.CHANNEL_DETAIL_INIT, channel.getChannelID().toString()));
                treeNode.setName(channel.getChannelName());
                treeNode.setTag(channel);

                // Set the root tree node as the parent tree node, if the parent ID is 0.
                if (channel.getParentID() == 0) {
                    treeNode.setParent(rootTreeNode);
                }

                if (channel.getParentID() == this.channelID) {
                    channelList.add(channel);
                }
                channelMap.put(channel.getChannelID(), treeNode);
            }

            // Set the tree node's parent
            for (CmsChannelDto channel : allChannels) {
                if (channel.getParentID() != 0) {
                    TreeNode treeNode = channelMap.get(channel.getChannelID());
                    TreeNode parent = channelMap.get(channel.getParentID());
                    parent.setUrl(StringUtil.replace(URLConstant.CHANNEL_LIST_INIT, channel.getParentID().toString()));
                    treeNode.setParent(parent);
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
