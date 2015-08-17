package com.iidooo.cms.action.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.channel.ChannelListService;
import com.iidooo.core.util.ValidateUtil;

public class ChannelListAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ChannelListService channelListService;

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
                SiteDto site = (SiteDto)this.getSessionValue(CmsConstant.SESSION_DEFAULT_SITE);
                channelList = channelListService.getChildrenChannelList(site.getSiteID(), 0);

                // The page should use the channel.parentID as the url parameter.
                channel = new ChannelDto();
                channel.setParentID(0);
            } else {
                // Get the current channel's children channel list
                channelList = channelListService.getChildrenChannelList(channel.getChannelID());
                channel.setParentID(channel.getChannelID());
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
            if (!channelListService.deleteChannel(this.channel)) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED", new String[] { channel.getChannelName() }));
                return INPUT;
            }

            addActionMessage(getText("MSG_CHANNEL_DELETE_SUCCESS", new String[] { channel.getChannelName() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateDelete() {
        try {
            if (channel == null || ValidateUtil.isEmpty(channel.getChannelID())) {
                addActionError(getText("MSG_CHANNEL_ID_REQUIRE"));
            }

            if (channelListService.hasChildren(channel.getChannelID())) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN", new String[] { channel.getChannelName() }));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
