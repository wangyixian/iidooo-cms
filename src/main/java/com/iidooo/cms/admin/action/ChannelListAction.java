package com.iidooo.cms.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.ChannelListService;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.constant.DateConstant;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.component.TreeNode;
import com.iidooo.framework.utility.DateTimeUtil;
import com.iidooo.framework.utility.StringUtil;

import freemarker.template.utility.DateUtil;

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
    private int parentChannelID = 0;
    
    private CmsChannelDto channel;

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

    

    public int getParentChannelID() {
        return parentChannelID;
    }

    public void setParentChannelID(int parentChannelID) {
        this.parentChannelID = parentChannelID;
    }

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    public String init() {
        try {

            // Build the channel tree' root node.
            String rootName = this.getText("LABEL_TREE_ROOT");
            rootTreeNode = channelService.getRootTree(rootName, URLConstant.CHANNEL_LIST_INIT, URLConstant.CHANNEL_DETAIL_INIT);

            channelList = new ArrayList<CmsChannelDto>();
            List<CmsChannelDto> allChannels = channelService.getAllChannels();
            for (CmsChannelDto channel : allChannels) {

                if (channel.getParentID() == this.parentChannelID) {
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

    public String delete() {
        try {
            channel.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
            boolean result = channelService.deleteChannel(this.channel);
            if (!result) {
                addActionError(getText("MST_DELETE_FAILED"));
                return INPUT;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void valideDelete() {
        CmsChannelDto channel = channelService.exclusiveCheck(this.channel.getChannelID(), this.channel.getVersion());
        if (channel == null) {
            addActionError(getText("MSG_EXCLUSIVE"));
        }

        List<CmsChannelDto> children = channelService.getChildrenChannels(this.channel.getChannelID());
        if (children != null && children.size() > 0) {
            addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN"));
        }
    }
}
