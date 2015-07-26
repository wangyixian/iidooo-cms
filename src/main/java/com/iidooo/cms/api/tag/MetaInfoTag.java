package com.iidooo.cms.api.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.core.util.HttpUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

public class MetaInfoTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(MetaInfoTag.class);

    private final String HTML_META_TITLE = "<title>{0}</title>";
    private final String HTML_META_KEYWORDS = "<meta name='keywords' content='{0}' >";
    private final String HTML_META_DESCRIPTION = "<meta name='description' content='{0}' >";

    private String siteCode;

    private String channelPath;

    private String contentID;

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

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            String cmsURL = (String) pageContext.getServletContext().getAttribute(CmsConstant.CMS_URL);

            JSONObject data = new JSONObject();
            data.put(CmsConstant.FIELD_SITE_CODE, siteCode);
            data.put(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
            JSONObject jsonObject = null;
            if (channelPath.equals(CmsConstant.CHANNEL_PATH_INDEX)) {
                // The site index page's meta info
                String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_SITE, data.toString());
                jsonObject = JSONObject.fromObject(response);
            } else {
                String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CHANNEL, data.toString());
                jsonObject = JSONObject.fromObject(response);
            }

            String metaTitle = jsonObject.getString(CmsConstant.FIELD_META_TITLE).toString();
            String metaKeywords = jsonObject.get(CmsConstant.FIELD_META_KEYWORDS).toString();
            String metaDescription = jsonObject.getString(CmsConstant.FIELD_META_DESCRIPTION).toString();

            if (!ValidateUtil.isEmpty(contentID)) {
                // If the content ID is not null, get this content's meta info.
                data = new JSONObject();
                data.put(CmsConstant.FIELD_CONTENT_ID, contentID);
                String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CONTENT, data.toString());
                if (!ValidateUtil.isEmpty(response)) {
                    jsonObject = JSONObject.fromObject(response);        
                    String contentMetaTitle = jsonObject.getString(CmsConstant.FIELD_META_TITLE).toString();
                    String contentMetaKeywords = jsonObject.get(CmsConstant.FIELD_META_KEYWORDS).toString();
                    String contentMetaDescription = jsonObject.getString(CmsConstant.FIELD_META_DESCRIPTION).toString();
                    
                    metaTitle += ("-" + contentMetaTitle);
                    metaKeywords += ("," + contentMetaKeywords);
                    metaDescription += ("," + contentMetaDescription);
                }
            }

            out.println(StringUtil.replace(HTML_META_TITLE, metaTitle));
            out.println(StringUtil.replace(HTML_META_KEYWORDS, metaKeywords));
            out.println(StringUtil.replace(HTML_META_DESCRIPTION, metaDescription));

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
