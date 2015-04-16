package com.iidooo.cms.action.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.ChannelDetailService;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelInfoService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.ValidateUtil;
import com.iidooo.framework.constant.SessionConstant;
import com.iidooo.framework.dto.extend.SecurityUserDto;
import com.iidooo.framework.exception.ExclusiveException;

public class ChannelInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelInfoAction.class);

    @Autowired
    private IChannelInfoService channelInfoService;

    private ChannelDto channel;

    private List<ChannelDto> allChannels;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public List<ChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<ChannelDto> allChannels) {
        this.allChannels = allChannels;
    }

    public String init() {
        try {            
            // The modify mode will trace the channel ID.
            if (channel != null && channel.getChannelID() != null && channel.getChannelID() > 0) {
                channel = channelInfoService.getCurrentChannel(channel.getChannelID());
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
            channel.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
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
            //commonValidate();

            // Check the same channel path is existed or not.
//            CmsChannelDto cmsChannelDto = channelDetailService.getChannelByPath(channel.getChannelPath());
//            if (cmsChannelDto != null) {
//                String msg = this.getText("MSG_CHANNEL_EXISTED", new String[] { getText("LABEL_CHANNEL_PATH") });
//                addFieldError("channel.channelPath", msg);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public String update() {
        try {
            channel.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
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
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public String delete() {
        try {
            channel.setSessionUser((SecurityUserDto) this.getSessionValue(SessionConstant.SECURITY_USER));
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
