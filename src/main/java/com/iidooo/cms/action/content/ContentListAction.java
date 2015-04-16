package com.iidooo.cms.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.channel.ChannelListAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.ContentService;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.content.impl.ContentListService;
import com.iidooo.core.action.PagingActionSupport;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.tag.component.TreeNode;

public class ContentListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private IChannelService channelService;
    
    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentListService contentListService;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    private int channelID = 0;

    private List<ContentDto> contentList;
    
    private int contentID;

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

    public List<ContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentDto> contentList) {
        this.contentList = contentList;
    }



    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String init() {
        try {            
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), CmsConstant.CONTENT_LIST_INIT);

            // Get all of the clicked channel's offspring channels.
            List<ChannelDto> offspringChannels = channelService.getOffspringChannels(channelID, true);
            int recordSum = contentService.getChannelContentsCount(offspringChannels);
            this.executePaging(recordSum);
            this.contentList = contentService.getChannelContents(offspringChannels, this.getPagingDto());

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
    
    public String delete() {
        try {            
            ContentDto content = new ContentDto();
            content.setContentID(this.getContentID());
            content.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
            boolean result = contentService.deleteContent(content);
            if (result) {
                this.setMessage(getText("MSG_DELETE_SUCCESS"));
            } else {
                this.setMessage(getText("MST_DELETE_FAILED"));
            }
            this.init();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
