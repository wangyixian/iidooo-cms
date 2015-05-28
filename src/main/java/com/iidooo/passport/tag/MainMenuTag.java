package com.iidooo.passport.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

public class MainMenuTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(MainMenuTag.class);

    private String focusMenu;

    public String getFocusMenu() {
        return focusMenu;
    }

    public void setFocusMenu(String focusMenu) {
        this.focusMenu = focusMenu;
    }

    @Override
    public void doTag() throws JspException, IOException {
        logger.debug("MainMenuTag doTag method execute start.");
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            ServletContext sc = pageContext.getServletContext();

            out.println("<ul id='mainmenu'>");

//                out.println(" <li>");
//                if (channelPath != null && item.getChannelPath().equals(channelPath)) {
//                    out.println("<a href='" + url + "'" + " class='focus'>");
//                    out.println(item.getChannelName());
//                    out.println("</a>");
//                } else {
//                    out.println("<a href='" + url + "'>");
//                    out.println(item.getChannelName());
//                    out.println("</a>");
//                }
                out.println("</li>");
            out.println("</ul>");
            logger.debug("MainMenuTag doTag method execute end.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
