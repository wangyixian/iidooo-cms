package com.iidooo.cms.api.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.util.HttpUtil;

public class ContentListTag extends SimpleTagSupport {
    private static final Logger logger = Logger.getLogger(ContentListTag.class);

    private String siteCode;

    private String channelPath;

    private String action;

    private int pageStart = 0;

    private int pageSize = 5;

    private boolean isShowImage = false;

    private boolean isShowDate = false;

    private String sortField = CoreConstants.SORT_FIELD_SEQUENCE;

    private String sortType = CoreConstants.SORT_TYPE_ASC;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getChannelPath() {
        return channelPath;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getIsShowImage() {
        return isShowImage;
    }

    public void setIsShowImage(boolean isShowImage) {
        this.isShowImage = isShowImage;
    }

    public boolean getIsShowDate() {
        return isShowDate;
    }

    public void setIsShowDate(boolean isShowDate) {
        this.isShowDate = isShowDate;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            String cmsURL = (String) pageContext.getServletContext().getAttribute(CmsConstant.CMS_URL);

            // Get the site URL for content's <a>;
            String siteURL = this.getSiteURL(siteCode, cmsURL);
            
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            data.put(CoreConstants.FIELD_PAGE_START, pageStart);
            data.put(CoreConstants.FIELD_PAGE_SIZE, pageSize);
            data.put(CoreConstants.FIELD_PAGE_SORT_FIELD, sortField);
            data.put(CoreConstants.FIELD_PAGE_SORT_TYPE, sortType);

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENTS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT);

            for (int i = 0; i < jsonArray.size(); i++) {

                JSONObject item = (JSONObject) jsonArray.get(i);
                String contentID = item.getString(CmsConstant.FIELD_CONTENT_ID);
                String contentTitle = item.getString(CmsConstant.FIELD_CONTENT_TITLE);
                String contentImageTitle = item.getString(CmsConstant.FIELD_CONTENT_IMAGE_TITLE);
                String contentDate = item.getString(CmsConstant.FIELD_CONTENT_UPDATE_DATE);

                out.println("<li>");
                out.println("<div class='block_content_item'>");

                if (isShowImage) {
                    out.println("<div class='block_content_item_image'>");
                    out.println("<a target='_blank' href='" + siteURL + '/' + action + "?content.contentID=" + contentID + "'>");
                    out.println("<img alt='" + contentTitle + "' src='" + contentImageTitle + "'>");
                    out.println("</a>");
                    out.println("</div>");
                }

                out.println("<div class='block_content_item_title'>");
                out.println("<a target='_blank' href='" + siteURL + '/' + action + "?content.contentID=" + contentID + "'>");
                out.println(contentTitle);
                out.println("</a>");
                out.println("</div>");

                if (isShowDate) {
                    out.println("<div class='block_content_item_date'>");
                    out.println(contentDate);
                    out.println("</div>");
                }

                out.println("</div>");
                out.println("</li>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private String getSiteURL(String siteCode, String cmsURL) {
        try {
            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_SITE, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            String siteURL = jsonObject.getString(CmsConstant.FIELD_SITE_URL);
            return siteURL;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return null;
        }
    }
}
