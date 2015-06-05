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

public class ChannelMenuTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelMenuTag.class);

    private final String HTML_A = "<a href='{0}'>{1}</a>";

    private final String HTML_A_FOCUS = "<a href='{0}' class='focus'>{1}</a>";

    private String siteCode;

    private String channelPath;

    private String level = "1";

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getChannelPath() {
        return channelPath;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
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
            data.put(CmsConstant.FIELD_CHANNEL_IS_HIDDEN, "0");
            data.put(CmsConstant.FIELD_CHANNEL_LEVEL, this.level);

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CHANNELS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT);

            if (jsonArray.size() <= 0) {
                return;
            }
            
            String siteURL = ((JSONObject) jsonArray.get(0)).getString(CmsConstant.FIELD_SITE_URL);

            out.println("<ul class='channel_menu'>");
            out.println("<li>");
            if (this.channelPath.equals(CmsConstant.CHANNEL_PATH_INDEX)) {
                out.println(StringUtil.replace(HTML_A_FOCUS, siteURL, "首页"));
            } else {
                out.println(StringUtil.replace(HTML_A, siteURL, "首页"));
            }
            out.println("</li>");
            for (int i = 0; i < jsonArray.size(); i++) {

                JSONObject item = (JSONObject) jsonArray.get(i);

                out.println("<li>");

                String channelName = item.getString(CmsConstant.FIELD_CHANNEL_NAME);
                String channelPath = item.getString(CmsConstant.FIELD_CHANNEL_PATH);

                String url = siteURL + "/" + channelPath;
                if (this.getChannelPath() != null && this.getChannelPath().equals(channelPath)) {
                    out.println(StringUtil.replace(HTML_A_FOCUS, url, channelName));
                } else {
                    out.println(StringUtil.replace(HTML_A, url, channelName));
                }

                out.println("</li>");
            }

            out.println("</ul>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
