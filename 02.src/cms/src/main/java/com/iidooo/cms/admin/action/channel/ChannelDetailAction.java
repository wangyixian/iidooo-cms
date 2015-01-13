package com.iidooo.cms.admin.action.channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.channel.ChannelDetailService;
import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsTemplateDto;
import com.iidooo.framework.action.BaseAction;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.exception.ExclusiveException;
import com.iidooo.framework.utility.StringUtil;
import com.iidooo.framework.utility.ValidateUtil;

public class ChannelDetailAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelDetailService channelDetailService;

    private CmsChannelDto channel;

    private int mode;

    private List<CmsChannelDto> allChannels;

    private List<CmsTemplateDto> allTemplates;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
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
            this.allChannels = channelDetailService.getAllChannels();
            Map<Integer, CmsChannelDto> channelMap = new HashMap<Integer, CmsChannelDto>();
            for (CmsChannelDto cmsChannelDto : allChannels) {
                channelMap.put(cmsChannelDto.getChannelID(), cmsChannelDto);
            }
            // Set the children
            for (CmsChannelDto cmsChannelDto : allChannels) {
                if (cmsChannelDto.getParentID() != 0) {
                    CmsChannelDto parent = channelMap.get(cmsChannelDto.getParentID());
                    parent.getChildren().add(cmsChannelDto);
                }
            }

            this.allTemplates = channelDetailService.getAllTemplates();

            switch (this.mode) {
            case 1:
                // The create model
                break;
            case 2:
                // The update model
                String channelIDStr = this.getRequestValue(AttributeConstant.CHANNEL_ID);
                int channelID = Integer.parseInt(channelIDStr);
                CmsChannelDto cmsChannelDto = channelDetailService.getCurrentChannel(channelID);
                channel = cmsChannelDto;
                break;
            default:
                break;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String create() {
        try {
            SecurityUserDto securityUserDto = (SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER);
            channel.setForCreate(securityUserDto.getUserID());
            channelDetailService.createChannel(channel);
            addActionMessage(getText("MSG_CREATE_SUCCESS"));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
            commonValidate();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public String update() {
        try {
            SecurityUserDto securityUserDto = (SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER);
            channel.setForUpdate(securityUserDto.getUserID());
            channelDetailService.updateChannel(channel);
            addActionMessage(getText("MSG_UPDATE_SUCCESS"));
            return SUCCESS;
        } catch (ExclusiveException exclusive) {
            addActionMessage(getText("MSG_EXCLUSIVE"));
            return INPUT;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {
            commonValidate();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void commonValidate() {
        try {
            if (ValidateUtil.isEmpty(channel.getChannelName())) {
                String msg = this.getText("MSG_COMMON_REQUIRED", new String[] { getText("LABEL_CHANNEL_NAME") });
                addFieldError("channel.channelName", msg);
            }
            if (ValidateUtil.isEmpty(channel.getChannelPath())) {
                String msg = this.getText("MSG_COMMON_REQUIRED", new String[] { getText("LABEL_CHANNEL_PATH") });
                addFieldError("channel.channelPath", msg);
            }
            CmsChannelDto cmsChannelDto = channelDetailService.getChannelByPath(channel.getChannelPath());
            if (cmsChannelDto != null) {
                String msg = this.getText("MSG_CHANNEL_EXISTED", new String[] { getText("LABEL_CHANNEL_PATH") });
                addFieldError("channel.channelPath", msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public String delete() {
        try {
            channelDetailService.deleteChannel(channel);
            addActionMessage(getText("MSG_DELETE_SUCCESS"));
            return SUCCESS;
        } catch (ExclusiveException exclusive) {
            addActionMessage(getText("MSG_EXCLUSIVE"));
            return INPUT;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
