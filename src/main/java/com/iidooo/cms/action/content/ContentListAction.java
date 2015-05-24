package com.iidooo.cms.action.content;

import java.util.List;

import org.apache.log4j.Logger;
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

    private List<ContentDto> contentList;
    
    private String siteCode;

    private ContentDto content;

    public List<ContentDto> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentDto> contentList) {
        this.contentList = contentList;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
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
                int count = contentListService.getContentListCount(0, siteCode);
                PageDto page = PageUtil.executePage(count, this.getPage());
                this.setPage(page);
                this.contentList = contentListService.getContentList(0, this.getPage(), siteCode);
            } else {
                int count = contentListService.getContentListCount(content.getChannelID(), siteCode);
                PageDto page = PageUtil.executePage(count, this.getPage());
                this.setPage(page);
                this.contentList = contentListService.getContentList(content.getChannelID(), this.getPage(), siteCode);
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
                addActionError(getText("MSG_CONTENT_DELETE_FAILED", new String[] { content.getContentTitle() }));
                return INPUT;
            }            
            
            // After successfully delete the content, initialize the page content list.
            this.init();
            
            addActionMessage(getText("MSG_CONTENT_DELETE_SUCCESS", new String[] { content.getContentTitle() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
