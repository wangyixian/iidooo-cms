package com.iidooo.cms.client.action.recruit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.action.CmsBaseAction;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.cms.service.ContentService;

public class RecruitAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(RecruitAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ContentService contentService;

    private CmsChannelDto channel;

    private CmsContentDto content;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    public CmsContentDto getContent() {
        return content;
    }

    public void setContent(CmsContentDto content) {
        this.content = content;
    }

    public String init() {
        try {
            this.channel = channelService.getChannelByID(channel.getChannelID());
            this.content = contentService.getContentByChannel(channel.getChannelID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
