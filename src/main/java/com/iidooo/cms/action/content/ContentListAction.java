package com.iidooo.cms.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.IContentListService;
import com.iidooo.core.dto.PageDto;
import com.opensymphony.xwork2.ActionSupport;

public class ContentListAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentListAction.class);

    @Autowired
    private IContentListService contentListService;

    private PageDto page;

    private List<ContentDto> contentList;

    private ContentDto content;

    public List<ContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentDto> contentList) {
        this.contentList = contentList;
    }

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    public String init() {
        try {
            if (content == null) {
                this.contentList = contentListService.getContentListByChannel(0, page);
            } else {
                this.contentList = contentListService.getContentListByChannel(content.getChannelID(), page);
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
            if (!contentListService.deleteContent(content)) {
                addActionError(getText("MSG_CONTENT_DELETE_FAILED", content.getContentTitle()));
                return INPUT;
            }

            addActionError(getText("MSG_CONTENT_DELETE_SUCCESS", content.getContentTitle()));
            this.contentList = contentListService.getContentListByChannel(content.getChannelID(), page);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
