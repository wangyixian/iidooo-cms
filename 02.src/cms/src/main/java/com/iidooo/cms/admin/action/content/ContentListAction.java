package com.iidooo.cms.admin.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.admin.action.channel.ChannelListAction;
import com.iidooo.cms.admin.service.content.ContentListService;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.action.PagingActionSupport;

public class ContentListAction extends PagingActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private ContentListService contentListService;

    private List<CmsContentDto> contentList;

    public List<CmsContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<CmsContentDto> contentList) {
        this.contentList = contentList;
    }

    public String init() {
        try {
            int recordSum = contentListService.getAllContentsCount();
            this.executePaging(recordSum);
            this.contentList = contentListService.getAllContents(this.getPagingDto());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
