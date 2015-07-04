package com.iidooo.cms.api.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class ChannelListTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelListTag.class);

    private final String HTML_LI = "<li id={0}><a href='#'>{1}</a></li>";

    private final String HTML_LI_ONCLICK = "<li id={0}><a href='#' onclick={2}>{1}</a></li>";

    private final String HTML_LI_FOCUS = "<li id={0} class='focus'><a href='#'>{1}</a></li>";

    private final String HTML_LI_FOCUS_ONCLICK = "<li id={0} class='focus'><a href='#' onclick={2}>{1}</a></li>";

    private String id;

    private String value;

    private boolean isContainBlank = true;

    private String siteCode;

    private String parentPath;

    private String onClick;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isContainBlank() {
        return isContainBlank;
    }

    public void setContainBlank(boolean isContainBlank) {
        this.isContainBlank = isContainBlank;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
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
            data.put(CmsConstant.FIELD_CHANNEL_PARENT_PATH, parentPath);

            String response = HttpUtil.doGet(cmsURL, CmsConstant.REST_API_CHANNELS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.REST_API_RESULT_LIST);

            if (jsonArray.size() <= 0) {
                return;
            }

            out.println("<ul id='" + id + "' class='channel_list'>");

            // Save the li html string and then write out them.
            List<String> liList = new ArrayList<String>();

            boolean isItemFocus = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = (JSONObject) jsonArray.get(i);
                String channelID = item.getString(CmsConstant.FIELD_CHANNEL_ID);
                String channelPath = item.getString(CmsConstant.FIELD_CHANNEL_PATH);
                String channelName = item.getString(CmsConstant.FIELD_CHANNEL_NAME);
                if (value != null && !value.isEmpty() && (value.equals(channelID) || value.equals(channelPath))) {
                    isItemFocus = true;

                    if (onClick != null && !onClick.isEmpty()) {
                        String function = this.getFunction(item);
                        liList.add(StringUtil.replace(HTML_LI_FOCUS_ONCLICK, id + "_" + channelID, channelName, function));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI_FOCUS, id + "_" + channelID, channelName));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = this.getFunction(item);
                        liList.add(StringUtil.replace(HTML_LI_ONCLICK, id + "_" + channelID, channelName, function));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI, id + "_" + channelID, channelName));
                    }
                }
            }

            // If the li list should contain blank, so insert the blank item in the index of 0.
            // If there is no item been focused, the blank item should be focus.
            if (isContainBlank) {
                if (isItemFocus) {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = this.getFunction(null);
                        liList.add(0, StringUtil.replace(HTML_LI_ONCLICK, id + "_0", "全部", function));
                    } else {
                        liList.add(0, StringUtil.replace(HTML_LI, id + "_0", "全部"));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = this.getFunction(null);
                        liList.add(0, StringUtil.replace(HTML_LI_FOCUS_ONCLICK, id + "_0", "全部", function));
                    } else {
                        liList.add(0, StringUtil.replace(HTML_LI_FOCUS, id + "_0", "全部"));
                    }
                }
            }

            // write out the html of li to the page.
            for (String li : liList) {
                out.println(li);
            }

            out.println("</ul>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
    
    private String getFunction(JSONObject item){
        String result = onClick;
        
        try {
            if (result.contains(CmsConstant.FIELD_CHANNEL_ID)) {
                if (item != null) {
                    String channelID = item.get(CmsConstant.FIELD_CHANNEL_ID).toString();
                    result = result.replace(CmsConstant.FIELD_CHANNEL_ID, channelID);
                } else {
                    result = result.replace(CmsConstant.FIELD_CHANNEL_ID, "");
                }
            } 
            if (result.contains(CmsConstant.FIELD_CHANNEL_PATH)) {
                if (item != null) {
                    String channelPath = item.get(CmsConstant.FIELD_CHANNEL_PATH).toString();
                    result = result.replace(CmsConstant.FIELD_CHANNEL_PATH, channelPath);
                } else {
                    result = result.replace(CmsConstant.FIELD_CHANNEL_PATH, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        
        return result;
    }
}
