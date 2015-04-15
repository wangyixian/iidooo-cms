package com.iidooo.cms.action.channel;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.component.TreeNode;

public class ChannelListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private IChannelListService channelListService;

    private List<ChannelDto> channelList;

    private ChannelDto channel;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    public List<ChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelDto> channelList) {
        this.channelList = channelList;
    }

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }
    
    public String init() {
        try {

            // Build the channel tree' root node.
            String rootName = this.getText("LABEL_TREE_ROOT");
            rootTreeNode = channelListService.getRootTree(rootName, URLConstant.CHANNEL_LIST_INIT, URLConstant.CHANNEL_DETAIL_INIT);

            channelList = channelListService.getChannelList(1);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
    
    public String search(){
        try {

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
        ChannelDto channel = channelService.exclusiveCheck(this.channel.getChannelID(), this.channel.getVersion());
        if (channel == null) {
            addActionError(getText("MSG_EXCLUSIVE"));
        }

        List<ChannelDto> children = channelService.getChildrenChannels(this.channel.getChannelID());
        if (children != null && children.size() > 0) {
            addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN"));
        }
    }
}
