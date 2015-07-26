package com.iidooo.cms.api.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IContentService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.JsonUtil;
import com.iidooo.core.util.PageUtil;
import com.iidooo.core.util.ValidateUtil;

public class ContentAction extends BaseAPIAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentAction.class);

    @Autowired
    private IContentService contentService;

    public void content() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:
                String contentID = this.getRequestParameter(CmsConstant.FIELD_CONTENT_ID);

                // If the content ID did not get, so this parameter will be used to get the default content.
                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                String channelPath = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_PATH);

                if (!ValidateUtil.isEmpty(contentID)) {
                    ContentDto content = contentService.getContent(Integer.parseInt(contentID));
                    JsonUtil.responseObject(content, this.getResponse());
                } else if (!ValidateUtil.isEmpty(siteCode) && !ValidateUtil.isEmpty(channelPath)) {
                    ContentDto content = contentService.getContent(siteCode, channelPath);
                    JsonUtil.responseObject(content, this.getResponse());
                }

                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    public void contents() {
        try {
            String method = this.getRequestMethod();
            switch (method) {
            case CoreConstants.HTTP_METHOD_GET:
                String siteCode = this.getRequestParameter(CmsConstant.FIELD_SITE_CODE);
                String channelPath = this.getRequestParameter(CmsConstant.FIELD_CHANNEL_PATH);
                String pageStart = this.getRequestParameter(CoreConstants.FIELD_PAGE_START);
                String pageSize = this.getRequestParameter(CoreConstants.FIELD_PAGE_SIZE);
                String sortField = this.getRequestParameter(CoreConstants.FIELD_PAGE_SORT_FIELD);
                String sortType = this.getRequestParameter(CoreConstants.FIELD_PAGE_SORT_TYPE);
                String currentPage = this.getRequestParameter(CoreConstants.FIELD_PAGE_CURRENT_PAGE);
                
                // The required item
                if (siteCode == null || siteCode.isEmpty() || channelPath == null || channelPath.isEmpty()) {
                    return;
                }
                
                // The option item set the default value.
                if (ValidateUtil.isEmpty(pageStart)) {
                    pageStart = "0";
                }                
                if (ValidateUtil.isEmpty(pageSize)) {
                    pageSize = "10";
                }
                if (ValidateUtil.isEmpty(sortField)) {
                    sortField = CoreConstants.SORT_FIELD_UPDATETIME;
                }
                if (ValidateUtil.isEmpty(sortType)) {
                    sortType = CoreConstants.SORT_TYPE_DESC;
                }
                if (ValidateUtil.isEmpty(currentPage)) {
                    currentPage = "1";
                }

                PageDto page = new PageDto();
                page.setStart(Integer.parseInt(pageStart));
                page.setPageSize(Integer.parseInt(pageSize));
                page.setSortField(sortField);
                page.setSortType(sortType);
                page.setCurrentPage(Integer.parseInt(currentPage));
                
                int count = contentService.getContentListSize(siteCode, channelPath);
                
                PageUtil pageUtil = new PageUtil(this.getServletContext());
                this.setPage(pageUtil.executePage(count, page));
                
                List<ContentDto> contentList = contentService.getContentList(siteCode, channelPath, this.getPage());

                JsonUtil.responseObjectArray(contentList, this.getPage(), this.getResponse());
                break;

            default:
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
