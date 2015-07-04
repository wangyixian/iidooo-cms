package com.iidooo.core.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;
import com.iidooo.core.dao.extend.DictItemDao;
import com.iidooo.core.dto.extend.DictItemDto;
import com.iidooo.core.util.SpringUtil;
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

            DictItemDao DictItemDao = (DictItemDao) SpringUtil.getBean(pageContext.getServletContext(), CoreConstants.BEAN_DICT_ITEM_DAO);
            List<DictItemDto> dictItemList = DictItemDao.selectByClassCode(dictClassCode);

            out.println("<ul id='" + id + "' class='dict_item_list'>");

            // Save the li html string and then write out them.
            List<String> liList = new ArrayList<String>();

            boolean isItemFocus = false;

            for (DictItemDto item : dictItemList) {
                String dictItemCode = item.getDictItemCode();
                String dictItemName = item.getDictItemName();
                if (value != null && !value.isEmpty() && value.equals(dictItemCode)) {
                    isItemFocus = true;
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = onClick.replace(CoreConstants.FIELD_DICT_ITEM_CODE, dictItemCode);
                        liList.add(StringUtil.replace(HTML_LI_FOCUS_ONCLICK, id + "_" + dictItemCode, dictItemName, function));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI_FOCUS, id + "_" + dictItemCode, dictItemName));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = onClick.replace(CoreConstants.FIELD_DICT_ITEM_CODE, dictItemCode);
                        liList.add(StringUtil.replace(HTML_LI_ONCLICK, id + "_" + dictItemCode, dictItemName, function));
                    } else {
                        liList.add(StringUtil.replace(HTML_LI, id + "_" + dictItemCode, dictItemName));
                    }
                }
            }

            // If the li list should contain blank, so insert the blank item in
            // the index of 0.
            // If there is no item been focused, the blank item should be focus.
            if (isContainBlank) {
                if (isItemFocus) {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = onClick.replace(CoreConstants.FIELD_DICT_ITEM_CODE, "0");
                        liList.add(0, StringUtil.replace(HTML_LI_ONCLICK, id + "_0", "全部", function));
                    } else {
                        liList.add(0, StringUtil.replace(HTML_LI, id + "_0", "全部"));
                    }
                } else {
                    if (onClick != null && !onClick.isEmpty()) {
                        String function = onClick.replace(CoreConstants.FIELD_DICT_ITEM_CODE, "0");
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

}
