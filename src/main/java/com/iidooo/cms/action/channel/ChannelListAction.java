package com.iidooo.cms.action.channel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.util.ValidateUtil;

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
                // List<RoleDto> roleList = (List<RoleDto>) this.getSessionValue(PassportConstant.LOGIN_ROLE_LIST);
                // List<SiteDto> siteList = channelListService.getSiteList(roleList);
                // Default is get the root channel list.
                SiteDto site = channelListService.getTopSite();
                channelList = channelListService.getChildrenChannelList(site.getSiteID(), 0);

                // The page should use the channel.parentID as the url parameter.
                channel = new ChannelDto();
                channel.setParentID(0);
                channel.setSiteID(site.getSiteID());
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
            channelList = channelListService.getChildrenChannelList(channel.getParentID());

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

            channel = channelListService.getChannel(channel.getChannelID());
            if (channel == null) {
                addActionError(getText("MSG_CHANNEL_NOT_EXIST"));
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
