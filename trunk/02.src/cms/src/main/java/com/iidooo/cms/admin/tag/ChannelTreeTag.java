package com.iidooo.cms.admin.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.cms.dto.extend.CmsChannelDto;

public class ChannelTreeTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelTreeTag.class);

    private List<CmsChannelDto> channelList;

    public List<CmsChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<CmsChannelDto> channelList) {
        this.channelList = channelList;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            JspContext jspCtx = getJspContext();
            JspWriter out = jspCtx.getOut();

            out.println("<ul class='filetree' id='channelTree'>");
            out.println("<li><span class='folder'>根目录</span>");
            out.println("<ul>");
            for (CmsChannelDto channelDto : channelList) {
                printHTML(out, channelDto);
            }
            out.println("</ul>");
            out.println("</li>");
            out.println("</ul>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
        }
    }

    private void printHTML(JspWriter out, CmsChannelDto channelDto) throws JspException, IOException {

        // If has children, the node class should be set
        if (channelDto.getChildren().size() > 0) {
            if (channelDto.getChildren().size() > 0) {
                out.println("<li class='closed'><span class='folder'>" + channelDto.getChannelName() + "</span>");
            } else {
                out.println("<li><span class='folder'>" + channelDto.getChannelName() + "</span>");
            }
            List<CmsChannelDto> children = channelDto.getChildren();
            out.println("<ul>");
            for (CmsChannelDto cmsChannelDto : children) {
                this.printHTML(out, cmsChannelDto);
            }
            out.println("</ul>");
            out.println(" </li>");
        } else {
            out.println("<li><span class='file'>" + channelDto.getChannelName() + "</span></li>");
        }

    }
}
