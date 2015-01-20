package com.iidooo.cms.client.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.service.ChannelService;
import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;

public class ChannelAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private ChannelService channelService;

    private CmsChannelDto currentChannel;

    public CmsChannelDto getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(CmsChannelDto currentChannel) {
        this.currentChannel = currentChannel;
    }

    @Override
    public String execute() throws Exception {
        try {
            HttpServletRequest request = this.getRequest();
            String channelPath = request.getParameter(AttributeConstant.CHANNEL_PATH);
            if (channelPath == null || channelPath == "") {
                channelPath = AttributeConstant.CHANNEL_PATH_INDEX;
            }
            currentChannel = channelService.getChannelByPath(channelPath);
            
            if (currentChannel == null) {
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
