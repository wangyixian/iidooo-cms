package com.iidooo.cms.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.util.HttpUtil;
import com.iidooo.core.util.SpringUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.framework.constant.SpringConstant;

public class ChannelMenuTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelMenuTag.class);

    private final String HTML_A = "<a href='{0}'>{1}</a>";

    private final String HTML_A_FOCUS = "<a href='{0}' class='focus'>{1}</a>";

    private String siteCode;

    private String channelPath;

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
            
            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CHANNELS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CmsConstant.REST_API_RESULT_CHANNEL_LIST);

            out.println("<ul class='channel_menu'>");
            for (int i = 0; i < jsonArray.size(); i++) {
                out.println(" <li>");

                JSONObject item = (JSONObject) jsonArray.get(i);
                String siteURL = item.getString(CmsConstant.FIELD_SITE_URL).toString();
                String channelName = item.get(CmsConstant.FIELD_CHANNEL_NAME).toString();
                String channelPath = item.getString(CmsConstant.FIELD_CHANNEL_PATH).toString();

                String url = siteURL + "/" + channelPath;
                if (channelPath != null && channelPath.equals(channelPath)) {
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
