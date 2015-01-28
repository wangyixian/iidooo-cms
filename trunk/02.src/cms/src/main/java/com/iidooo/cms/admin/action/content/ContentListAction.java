package com.iidooo.cms.admin.action.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.action.channel.ChannelListAction;
import com.iidooo.cms.admin.service.content.ContentListService;
import com.iidooo.cms.constant.FieldConstant;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.dto.extend.FieldModelDto;
import com.iidooo.framework.service.FieldModelService;
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
    
    @Autowired
    private FieldModelService fieldModelService;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    private int channelID;

    private List<CmsContentDto> contentList;

    private List<FieldModelDto> fieldModelList;

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

    public List<FieldModelDto> getFieldModelList() {
        return fieldModelList;
    }

    public void setFieldModelList(List<FieldModelDto> fieldModelList) {
        this.fieldModelList = fieldModelList;
    }

    public String init() {
        try {

            fieldModelList = fieldModelService.getByModelType(FieldConstant.FIELD_MODEL_TYPE_CONTENT);
            
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), URLConstant.CONTENT_LIST_INIT);

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
