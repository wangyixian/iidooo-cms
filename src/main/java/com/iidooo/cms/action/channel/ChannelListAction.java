package com.iidooo.cms.action.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.dto.PageDto;

public class ChannelListAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private IChannelListService channelListService;

    private List<ChannelDto> channelList;

    private ChannelDto channel;

    public List<ChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelDto> channelList) {
        this.channelList = channelList;
    }

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public String init() {
        try {
            if (channel == null) {
                // Default is get the root channel list.
                channelList = channelListService.getChildrenChannelList(0);
            } else {
                // Get the current channel's children channel list
                channelList = channelListService.getChildrenChannelList(channel.getChannelID());
            }
            
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String delete() {
        try {
            List<ChannelDto> children = channelListService.getChildrenChannelList(this.channel.getChannelID());
            if (children != null && children.size() > 0) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN", this.channel.getChannelName()));
                return INPUT;
            } else if (!channelListService.deleteChannel(this.channel)) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED", this.channel.getChannelName()));
                return INPUT;
            }
            channelList = channelListService.getChildrenChannelList(channel.getParentID());
            
            addActionMessage(getText("MSG_CHANNEL_DELETE_SUCCESS", this.channel.getChannelName()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
