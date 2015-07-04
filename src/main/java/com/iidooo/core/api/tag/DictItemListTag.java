package com.iidooo.core.api.tag;

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

public class DictItemListTag extends SimpleTagSupport {
    private static final Logger logger = Logger.getLogger(DictItemListTag.class);

    private final String HTML_LI = "<li id={0}><a href='#'>{1}</a></li>";

    private final String HTML_LI_ONCLICK = "<li id={0}><a href='#' onclick={2}>{1}</a></li>";

    private final String HTML_LI_FOCUS = "<li id={0} class='focus'><a href='#'>{1}</a></li>";

    private final String HTML_LI_FOCUS_ONCLICK = "<li id={0} class='focus'><a href='#' onclick={2}>{1}</a></li>";

    private String id;

    private String value;

    private String dictClassCode;

    private boolean isContainBlank = true;

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

    public String getDictClassCode() {
        return dictClassCode;
    }

    public void setDictClassCode(String dictClassCode) {
        this.dictClassCode = dictClassCode;
    }

    public boolean getIsContainBlank() {
        return isContainBlank;
    }

    public void setIsContainBlank(boolean isContainBlank) {
        this.isContainBlank = isContainBlank;
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
            data.put(CoreConstants.FIELD_DICT_CLASS_CODE, dictClassCode);
            String response = HttpUtil.doGet(cmsURL, CoreConstants.REST_API_DICT_ITEMS, data.toString());
            JSONObject jsonObject = JSONObject.fromObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(CoreConstants.FIELD_DICT_ITEM_LIST);
            if (jsonArray.size() <= 0) {
                return;
            }

            out.println("<ul id='" + id + "' class='dict_item_list'>");

            // Save the li html string and then write out them.
            List<String> liList = new ArrayList<String>();

            boolean isItemFocus = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = (JSONObject) jsonArray.get(i);
                String dictItemCode = item.get(CoreConstants.FIELD_DICT_ITEM_CODE).toString();
                String dictItemName = item.get(CoreConstants.FIELD_DICT_ITEM_NAME).toString();
                if (value != null && !value.isEmpty() && value.equals(dictItemCode)) {
                    isItemFocus = true;
                    if (onClick != null && !onClick.isEmpty()) {
                        liList.add(StringUtil.replace(HTML_LI_FOCUS_ONCLICK.replace(CoreConstants.FIELD_DICT_ITEM_CODE, dictItemCode), id + "_"
                                + dictItemCode, dictItemName, onClick));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI_FOCUS, id + "_" + dictItemCode, dictItemName));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        liList.add(StringUtil.replace(HTML_LI_ONCLICK.replace(CoreConstants.FIELD_DICT_ITEM_CODE, dictItemCode), id + "_" + dictItemCode, dictItemName,
                                onClick));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI, id + "_" + dictItemCode, dictItemName));
                    }
                }
            }

            // If the li list should contain blank, so insert the blank item in the index of 0.
            // If there is no item been focused, the blank item should be focus.
            if (isContainBlank) {
                if (isItemFocus) {
                    if (onClick != null && !onClick.isEmpty()) {
                        liList.add(0, StringUtil.replace(HTML_LI_ONCLICK.replace(CoreConstants.FIELD_DICT_ITEM_CODE,  "0"), id + "_0", "全部"));
                    } else {
                        liList.add(0, StringUtil.replace(HTML_LI, id + "_0", "全部"));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        liList.add(0, StringUtil.replace(HTML_LI_FOCUS_ONCLICK.replace(CoreConstants.FIELD_DICT_ITEM_CODE, "0"), id + "_0", "全部"));
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
}
