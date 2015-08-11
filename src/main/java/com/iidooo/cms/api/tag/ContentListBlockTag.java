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
import com.iidooo.core.util.StringUtil;

public class ContentListBlockTag extends SimpleTagSupport {
    private static final Logger logger = Logger.getLogger(ContentListBlockTag.class);

    private final String DIV_BLOCK_START = "<div id={0} class='block'>";

    private final String DIV_BLOCK_TITLE = "<div class='block_title'><a class='block_title_main' href='{0}'>{1}</a></div>";

    private String siteCode;

    private String id;

    private String title;

    private String channelPath;

    private String action;

    private int pageStart = 0;

    private int pageSize = 10;
    
    private boolean isShowTitle = true;
    
    private boolean isShowSummary = false;

    private boolean isShowImage = false;

    private boolean isShowDate = false;

    private String sortField = CoreConstants.SORT_FIELD_UNIQUE_VISITOR;

    private String sortType = CoreConstants.SORT_TYPE_ASC;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    
    public boolean getIsShowTitle(){
        return isShowTitle;
    }
    
    public void setIsShowTitle(Boolean isShowTitle){
        this.isShowTitle = isShowTitle;
    }
    
    public boolean getIsShowSummary(){
        return isShowSummary;
    }
    
    public void setIsShowSummary(boolean isShowSummary){
        this.isShowSummary = isShowSummary;
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

            String cmsBaseURL = cmsURL.substring(0, cmsURL.lastIndexOf("/"));

            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            data.put(CoreConstants.FIELD_PAGE_START, pageStart);
            data.put(CoreConstants.FIELD_PAGE_SIZE, pageSize);
            data.put(CoreConstants.FIELD_PAGE_SORT_FIELD, sortField);
            data.put(CoreConstants.FIELD_PAGE_SORT_TYPE, sortType);

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENTS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT_LIST);

            out.println(StringUtil.replace(DIV_BLOCK_START, this.id));
            out.println(StringUtil.replace(DIV_BLOCK_TITLE, this.channelPath + ".action", this.title));
            out.println("<div class='block_content'>");
            out.println("<ul>");
            for (int i = 0; i < jsonArray.size(); i++) {

                JSONObject item = (JSONObject) jsonArray.get(i);
                String contentID = item.getString(CmsConstant.FIELD_CONTENT_ID);
                String contentTitle = item.getString(CmsConstant.FIELD_CONTENT_TITLE);
                String contentImageTitle = item.getString(CmsConstant.FIELD_CONTENT_IMAGE_TITLE);
                String contentDate = item.getString(CmsConstant.FIELD_CONTENT_UPDATE_DATE);
                String contentSummary = item.getString(CmsConstant.FIELD_CONTENT_SUMMARY);
                
                out.println("<li>");
                out.println("<div class='block_content_item'>");

                if (isShowImage) {
                    out.println("<div class='block_content_item_image'>");
                    out.println("<a target='_blank' href='" + action + "?content.contentID=" + contentID + "'>");
                    out.println("<img alt='" + contentTitle + "' src='" + cmsBaseURL + contentImageTitle + "'>");
                    out.println("</a>");
                    out.println("</div>");
                }

                // If show summary, the content detail should be wrapped for layout.
                if (isShowSummary) {
                    out.println("<div class='block_content_item_text'>");
                }
                
                if (isShowTitle) {
                    out.println("<div class='block_content_item_title'>");
                    out.println("<a target='_blank' href='" + action + "?content.contentID=" + contentID + "'>");
                    out.println(contentTitle);
                    out.println("</a>");
                    out.println("</div>");
                }

                if (isShowDate) {
                    out.println("<div class='block_content_item_date'>");
                    out.println(contentDate);
                    out.println("</div>");
                }
                
                if (isShowSummary) {
                    out.println("<div class='block_content_item_summary'>");
                    out.println(contentSummary);
                    out.println("</div>");
                    out.println("</div>");
                }

                out.println("</div>");
                out.println("</li>");
            }
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
