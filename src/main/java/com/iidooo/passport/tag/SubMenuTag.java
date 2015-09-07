package com.iidooo.passport.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;
import com.iidooo.passport.constant.PassportConstant;
import com.iidooo.passport.dto.extend.ResourceDto;

public class SubMenuTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(SubMenuTag.class);

    private final String HTML_LI = "<li class='sub_menu_item'><a href='{0}'>{1}</a></li>";

    private final String HTML_LI_FOCUS = "<li class='sub_menu_item'><a class='focus' href='{0}'>{1}</a></li>";

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            ServletContext sc = pageContext.getServletContext();

            ResourceDto currentRootResource = (ResourceDto) sc.getAttribute(PassportConstant.CURRENT_ROOT_RESOURCE);

            out.println("<div id='subMenu' class='sub_menu'>");

            if (!ValidateUtil.isEmpty(title)) {
                out.println("<div class='sub_menu_title'>");
                out.println(title);
                out.println("</div>");
            }

            out.println("<ul>");
            for (ResourceDto item : currentRootResource.getChildren()) {

                // If the resource was set as invisible, it should not be shown in the menu.
                if (item.getInvisible() != 0) {
                    continue;
                }

                if (item.getIsSelected()) {
                    out.println(StringUtil.replace(HTML_LI_FOCUS, item.getResourceURL(), item.getResourceName()));
                } else {
                    out.println(StringUtil.replace(HTML_LI, item.getResourceURL(), item.getResourceName()));
                }
            }

            out.println("</ul>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
