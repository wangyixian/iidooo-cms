package com.iidooo.cms.client.action.blog;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.service.blog.BlogListService;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.service.ChannelService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.action.PagingActionSupport;

public class BlogListAction extends PagingActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BlogListAction.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ContentService contentService;

    private CmsChannelDto channel;

    public CmsChannelDto getChannel() {
        return channel;
    }

    public void setChannel(CmsChannelDto channel) {
        this.channel = channel;
    }

    private List<CmsContentDto> articles;

    public List<CmsContentDto> getArticles() {
        return articles;
    }

    public void setArticles(List<CmsContentDto> articles) {
        this.articles = articles;
    }

    public String init() {
        try {
            channel = channelService.getChannelByID(channel.getChannelID());
            List<CmsChannelDto> channels = channelService.getOffspringChannels(channel.getChannelID(), true);
            int recordSum = contentService.getChannelContentsCount(channels);
            this.executePaging(recordSum, 10);
            articles = contentService.getChannelContents(channels, this.getPagingDto());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
