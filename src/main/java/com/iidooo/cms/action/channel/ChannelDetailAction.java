package com.iidooo.cms.action.channel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelDetailService;
import com.opensymphony.xwork2.ActionSupport;

public class ChannelDetailAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelDetailAction.class);

    @Autowired
    private IChannelDetailService channelInfoService;

    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public String init() {
        try {
            // The modify mode will trace the channel ID.
            if (channel != null && channel.getChannelID() != null && channel.getChannelID() > 0) {
                channel = channelInfoService.getChannelByID(channel.getChannelID());
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

            if (channelInfoService.getChannelByPath(channel.getChannelPath()) != null) {
                addActionError(getText("MSG_CHANNEL_CREATE_FAILED_DUPLICATE"));
                return INPUT;
            }

            if (!channelInfoService.createChannel(channel)) {
                addActionError(getText("MSG_CHANNEL_CREATE_FAILED"));
                return INPUT;
            }
            addActionMessage(getText("MSG_CHANNEL_CREATE_SUCCESS"));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateCreate() {
        try {
            if (channel.getChannelName().isEmpty()) {
                addActionError(getText("MSG_CHANNEL_NAME_REQUIRE"));
            }
            if (channel.getChannelPath().isEmpty()) {
                addActionError(getText("MSG_CHANNEL_PATH_REQUIRE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }

    public String update() {
        try {
            if (!channelInfoService.updateChannel(channel)) {
                addActionError(getText("MSG_CHANNEL_UPDATE_FAILED", channel.getChannelName()));
                return INPUT;
            }
            addActionMessage(getText("MSG_CHANNEL_UPDATE_SUCCESS", channel.getChannelName()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateUpdate() {
        try {
            if (channel.getChannelName().isEmpty()) {
                addActionError(getText("MSG_CHANNEL_NAME_REQUIRE"));
            }
            if (channel.getChannelPath().isEmpty()) {
                addActionError(getText("MSG_CHANNEL_PATH_REQUIRE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            addActionError(getText("MSG_VALIDATION_EXCEPTION"));
        }
    }
}
