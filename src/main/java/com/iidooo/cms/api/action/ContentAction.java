package com.iidooo.cms.api.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.api.service.IContentService;
import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.action.BaseAPIAction;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dto.PageDto;
import com.iidooo.core.util.JsonUtil;

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

                if (contentID == null || contentID.isEmpty()) {
                    return;
                }

                ContentDto content = contentService.getContent(Integer.parseInt(contentID));

                JsonUtil.responseObject(content, this.getResponse());
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
                String pageStart = this.getRequestParameter(CoreConstants.PAGE_FIELD_START);
                String pageSize = this.getRequestParameter(CoreConstants.PAGE_FIELD_SIZE);
                String sortField = this.getRequestParameter(CoreConstants.PAGE_FIELD_SORT_FIELD);
                String sortType = this.getRequestParameter(CoreConstants.PAGE_FIELD_SORT_TYPE);

                if (siteCode == null || siteCode.isEmpty() || channelPath == null || channelPath.isEmpty() || pageStart == null
                        || pageStart.isEmpty() || pageSize == null || pageSize.isEmpty() || sortField == null || sortField.isEmpty()
                        || sortType == null || sortType.isEmpty()) {
                    return;
                }

                PageDto page = new PageDto();
                page.setStart(Integer.parseInt(pageStart));
                page.setPageSize(Integer.parseInt(pageSize));
                page.setSortField(sortField);
                page.setSortType(sortType);

                List<ContentDto> contentList = contentService.getContentList(siteCode, channelPath, page);

                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = JSONArray.fromObject(contentList);
                jsonObject.put(CmsConstant.REST_API_RESULT_CONTENT_LIST, jsonArray);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentType(CoreConstants.APPLICATION_JSON);
                response.setCharacterEncoding(CoreConstants.ENCODING_UTF8);
                PrintWriter writer = response.getWriter();
                writer.write(jsonObject.toString());
                writer.close();
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
