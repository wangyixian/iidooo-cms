package com.iidooo.cms.admin.action.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.action.channel.ChannelListAction;
import com.iidooo.cms.admin.service.content.ContentListService;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.tag.TreeNode;
import com.iidooo.framework.utility.StringUtil;

public class ContentListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ContentListService contentListService;

    // The channel tree's root node
    private TreeNode rootTreeNode;
    
    private int channelID;

    private List<CmsContentDto> contentList;

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

    public List<CmsContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<CmsContentDto> contentList) {
        this.contentList = contentList;
    }

    public String init() {
        try {

            // Build the channel tree' root node.
            rootTreeNode = new TreeNode();
            rootTreeNode.setUrl(StringUtil.replace(URLConstant.CONTENT_LIST_INIT, "0"));
            rootTreeNode.setName(this.getText("LABEL_TREE_ROOT"));

            List<CmsChannelDto> allChannels = channelService.getAllChannels();

            Map<Integer, TreeNode> channelMap = new HashMap<Integer, TreeNode>();
            for (CmsChannelDto channel : allChannels) {
                // Build the tree node of the CmsChannelDto
                TreeNode treeNode = new TreeNode();
                treeNode.setUrl(StringUtil.replace(URLConstant.CONTENT_LIST_INIT, channel.getChannelID().toString()));
                treeNode.setName(channel.getChannelName());
                treeNode.setTag(channel);

                // Set the root tree node as the parent tree node, if the parent ID is 0.
                if (channel.getParentID() == 0) {
                    treeNode.setParent(rootTreeNode);
                }

                channelMap.put(channel.getChannelID(), treeNode);
            }

            // Set the tree node's parent
            for (CmsChannelDto channel : allChannels) {
                if (channel.getParentID() != 0) {
                    TreeNode treeNode = channelMap.get(channel.getChannelID());
                    TreeNode parent = channelMap.get(channel.getParentID());
                    treeNode.setParent(parent);
                }
            }

            // Get all of the clicked channel's offspring channels.
            List<CmsChannelDto> offspringChannels = channelService.getOffspringChannels(channelID, true);
            int recordSum = contentListService.getChannelContentsCount(offspringChannels);
            this.executePaging(recordSum);
            this.contentList = contentListService.getChannelContents(offspringChannels, this.getPagingDto());
             
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
