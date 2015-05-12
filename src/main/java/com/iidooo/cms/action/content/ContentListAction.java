package com.iidooo.cms.action.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.content.IContentListService;
import com.iidooo.core.action.BaseAction;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.PageUtil;

public class ContentListAction extends BaseAction {

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

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }

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
            if (content == null || content.getChannelID() == null) {
                int count = contentListService.getContentListCount(0);
                page = PageUtil.executePage(count, page);
                this.contentList = contentListService.getContentList(0, page);
            } else {
                int count = contentListService.getContentListCount(content.getChannelID());
                page = PageUtil.executePage(count, page);
                this.contentList = contentListService.getContentList(content.getChannelID(), page);
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
            this.contentList = contentListService.getContentList(content.getChannelID(), page);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
