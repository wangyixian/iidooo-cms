package com.iidooo.cms.admin.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.action.channel.ChannelListAction;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.cms.service.TemplateService;
import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.dto.extend.FieldModelDto;
import com.iidooo.framework.tag.TreeNode;

public class ContentDetailAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelService channelService;
    
    @Autowired
    private TemplateService templateService;

    private FieldModelDto fieldModel;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    private CmsContentDto content;

    private List<CmsChannelDto> allChannels;

    private List<CmsTemplateDto> allTemplates;

    public FieldModelDto getFieldModel() {
        return fieldModel;
    }

    public void setFieldModel(FieldModelDto fieldModel) {
        this.fieldModel = fieldModel;
    }

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    public CmsContentDto getContent() {
        return content;
    }

    public void setContent(CmsContentDto content) {
        this.content = content;
    }

    public List<CmsChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<CmsChannelDto> allChannels) {
        this.allChannels = allChannels;
    }

    public List<CmsTemplateDto> getAllTemplates() {
        return allTemplates;
    }

    public void setAllTemplates(List<CmsTemplateDto> allTemplates) {
        this.allTemplates = allTemplates;
    }

    public String init() {
        try {
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), URLConstant.CONTENT_LIST_INIT);
            allChannels = channelService.getAllChannels();
            allTemplates = templateService.getAllTemplates();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
