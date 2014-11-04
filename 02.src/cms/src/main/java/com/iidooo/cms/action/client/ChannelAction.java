package com.iidooo.cms.action.client;

import java.nio.channels.Channels;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.framework.action.BaseAction;

public class ChannelAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private ChannelService channelService;

    private CmsChannelDto currentChannel;

    private List<CmsChannelDto> allChannels;

    public CmsChannelDto getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(CmsChannelDto currentChannel) {
        this.currentChannel = currentChannel;
    }

    public List<CmsChannelDto> getAllChannels() {
        return allChannels;
    }

    public void setAllChannels(List<CmsChannelDto> allChannels) {
        this.allChannels = allChannels;
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
            allChannels = channelService.getAllChannels();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
