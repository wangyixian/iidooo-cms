package com.iidooo.cms.action.content;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.action.CmsBaseAction;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.cms.service.content.ContentListService;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.PageUtil;
import com.iidooo.core.util.ValidateUtil;

public class ContentListAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentListAction.class);

    @Autowired
    private ContentListService contentListService;

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
            // The default initialization
            SiteDto site = (SiteDto)this.getSessionValue(CmsConstant.SESSION_DEFAULT_SITE);
            if (content == null || content.getChannelID() == null) {
                int count = contentListService.getContentListCount(site.getSiteID(), 0);

                PageUtil pageUtil = new PageUtil(this.getServletContext());
                PageDto page = pageUtil.executePage(count, this.getPage());
                this.setPage(page);

                this.contentList = contentListService.getContentList(site.getSiteID(), 0, this.getPage());

                // The page should use the content.siteID as the url parameter.
                content = new ContentDto();
                content.setSiteID(site.getSiteID());
            } else {
                int count = contentListService.getContentListCount(site.getSiteID(), content.getChannelID());

                PageUtil pageUtil = new PageUtil(this.getServletContext());
                PageDto page = pageUtil.executePage(count, this.getPage());
                this.setPage(page);

                this.contentList = contentListService.getContentList(site.getSiteID(), content.getChannelID(), this.getPage());
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

            addActionMessage(getText("MSG_CONTENT_DELETE_SUCCESS", new String[] { content.getContentTitle() }));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public void validateDelete() {
        try {
            if (content == null || ValidateUtil.isEmpty(content.getContentID())) {
                addActionError(getText("MSG_CONTENT_ID_REQUIRE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
