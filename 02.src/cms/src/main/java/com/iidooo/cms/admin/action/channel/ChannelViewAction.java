package com.iidooo.cms.admin.action.channel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.service.channel.ChannelCreateService;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.action.BaseAction;

public class ChannelViewAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelCreateService channelDetailService;

    private CmsChannelDto channel;

    private String mode;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String init() {
        try {
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String save() {
        try {
            channelDetailService.createChannel(channel);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validatesave() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
