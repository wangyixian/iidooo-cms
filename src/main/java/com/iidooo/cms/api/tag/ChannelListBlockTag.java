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
import com.iidooo.core.util.ValidateUtil;

public class ChannelListBlockTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelListBlockTag.class);

    private final String DIV_BLOCK_START = "<div id={0} class='block'>";

    private final String DIV_BLOCK_TITLE = "<div class='block_title'><a class='block_title_main' href='{0}'>{1}</a></div>";
    
    private final String HTML_LI = "<li id={0} class='block_content_item'><a href='#'>{1}</a></li>";

    private final String HTML_LI_ONCLICK = "<li id={0} class='block_content_item'><a href='#' onclick={2}>{1}</a></li>";

    private final String HTML_LI_FOCUS = "<li id={0} class='block_content_item'><a class='focus' href='#'>{1}</a></li>";

    private final String HTML_LI_FOCUS_ONCLICK = "<li id={0} class='block_content_item'><a class='focus' href='#' onclick={2}>{1}</a></li>";

    private String id;

    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsContainBlank() {
        return isContainBlank;
    }

    public void setIsContainBlank(boolean isContainBlank) {
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

            out.println(StringUtil.replace(DIV_BLOCK_START, this.id));
            if (!ValidateUtil.isEmpty(this.title)) {
                out.println(StringUtil.replace(DIV_BLOCK_TITLE, this.parentPath, this.title));
            }
            out.println("<div class='block_content'>");
            
            out.println("<ul>");

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

            out.println("</div>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private String getFunction(JSONObject item) {
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
                    // If the item is null, this is the blank item.
                    // Set the parent path as the parameter, then all of the children channel's content will be gotten.
                    result = result.replace(CmsConstant.FIELD_CHANNEL_PATH, this.parentPath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

        return result;
    }
}
