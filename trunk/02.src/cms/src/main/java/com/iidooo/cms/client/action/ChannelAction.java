package com.iidooo.cms.client.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.service.ChannelService;

public class ChannelAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private ChannelService channelService;

    private CmsChannelDto channel;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    @Override
    public String execute() throws Exception {
        try {
            if(channel == null || channel.getChannelPath() == null){
                channel.setChannelPath(AttributeConstant.CHANNEL_PATH_INDEX);
            }
            
            channel = channelService.getChannelByPath(channel.getChannelPath());

            if (channel == null) {
                return NONE;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
            return ERROR;
        }
    }

}
