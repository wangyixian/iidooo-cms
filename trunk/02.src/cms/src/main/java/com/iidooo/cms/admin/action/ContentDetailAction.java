package com.iidooo.cms.admin.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.ContentDetailService;
import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.cms.service.TemplateService;
import com.iidooo.framework.action.BaseDetailAction;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.dto.extend.FieldDataDto;
import com.iidooo.framework.dto.extend.FieldModelDto;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.enumeration.TableName;
import com.iidooo.framework.service.FieldConfigService;
import com.iidooo.framework.service.FieldDataService;
import com.iidooo.framework.service.FieldModelService;
import com.iidooo.framework.tag.TreeNode;

public class ContentDetailAction extends BaseDetailAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentDetailService contentDetailService;

    @Autowired
    private TemplateService templateService;
    
    @Autowired
    private FieldModelService fieldModelService;

    @Autowired
    private FieldConfigService fieldConfigService;

    @Autowired
    private FieldDataService fieldDataService;

    // The channel tree's root node
    private TreeNode rootTreeNode;

    private CmsContentDto content;

    private List<CmsChannelDto> allChannels;

    private List<CmsTemplateDto> allTemplates;
    
    private List<FieldModelDto> fieldModels;

    private List<FieldConfigDto> fieldConfigs;

    private List<FieldDataDto> fieldDatas;

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

    public List<FieldModelDto> getFieldModels() {
        return fieldModels;
    }

    public void setFieldModels(List<FieldModelDto> fieldModels) {
        this.fieldModels = fieldModels;
    }

    public List<FieldConfigDto> getFieldConfigs() {
        return fieldConfigs;
    }

    public void setFieldConfigs(List<FieldConfigDto> fieldConfigs) {
        this.fieldConfigs = fieldConfigs;
    }

    public List<FieldDataDto> getFieldDatas() {
        return fieldDatas;
    }

    public void setFieldDatas(List<FieldDataDto> fieldDatas) {
        this.fieldDatas = fieldDatas;
    }

    @Override
    public String init() {
        try {
            rootTreeNode = channelService.getRootTree(getText("LABEL_TREE_ROOT"), URLConstant.CONTENT_LIST_INIT);
            allChannels = channelService.getAllChannels();
            allTemplates = templateService.getAllTemplates();

            fieldModels = fieldModelService.getFieldModelList(TableName.IDO_CMS_CONTENT);
            
//            // The modify mode
//            if (content != null && content.getContentID() != null && content.getContentID() > 0) {
//                content = contentService.getContentByID(content.getContentID());
//                fieldConfigs = fieldConfigService.getFieldConfigList(content.getModelID());
//                // The content existed, should get the extend field data.
//                if (fieldConfigs != null && fieldConfigs.size() > 0) {
//                    fieldDatas = fieldDataService.getFieldDataList(fieldConfigs, content.getContentID());
//                }
//            } else {
//                // The create mode
//                if (content != null && content.getModelID() != null && content.getModelID() > 0) {
//                    fieldConfigs = fieldConfigService.getFieldConfigList(content.getModelID());
//                }
//            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String create() {
        try {
            SecurityUserDto securityUserDto = (SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER);
            contentDetailService.createContent(securityUserDto.getUserID(), content, fieldDatas);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String update() {
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String delete() {
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void uploadImageTitle() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
