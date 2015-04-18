package com.iidooo.cms.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.core.util.SpringUtil;
import com.iidooo.core.util.StringUtil;

public class ChannelTreeTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ChannelTreeTag.class);

    private final String FILE_TREE_NODE = "<span class='file'><a href={0}>{1}</a></span>";

    private final String FOLD_TREE_NODE = "<span class='folder'><a href={0}>{1}</a></span>";

    private String title;

    private String baseURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            out.println("<div class='tree_wrap'>");
            out.println("<div class='title'>");
            out.println(this.title);
            out.println("</div>");

            ChannelDao channelDao = (ChannelDao) SpringUtil.getBean(pageContext.getServletContext(), CmsConstant.BEAN_CHANNEL_DAO);

            out.println("<ul class='filetree' id='tree'>");
            String url = StringUtil.replace(baseURL, "0");
            String folder = StringUtil.replace(FOLD_TREE_NODE, url, this.title);
            out.println("<li>" + folder);

            List<ChannelDto> channelList = channelDao.selectAll();
            counstructChildren(channelList);

            if (channelList.size() > 0) {
                out.println("<ul>");
                for (ChannelDto item : channelList) {
                    printHTML(out, item);
                }
                out.println("</ul>");
            } else {
                logger.warn("The root tree node has not any child.");
            }
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void printHTML(JspWriter out, ChannelDto channelDto) throws JspException, IOException {
        try {
            // If has children, the node class should be set
            String url = StringUtil.replace(baseURL, channelDto.getChannelID().toString());
            if (channelDto.getChildren().size() > 0) {
                String folder = StringUtil.replace(FOLD_TREE_NODE, url, channelDto.getChannelName());
                out.println("<li class='closed'>" + folder);

                List<ChannelDto> children = channelDto.getChildren();
                out.println("<ul>");
                for (ChannelDto child : children) {
                    this.printHTML(out, child);
                }
                out.println("</ul>");
                
                out.println(" </li>");
            } else {
                String file = StringUtil.replace(FILE_TREE_NODE, url, channelDto.getChannelName());
                out.println("<li>" + file + "</li>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void counstructChildren(List<ChannelDto> channelList) {
        try {
            Map<Integer, ChannelDto> channelMap = new HashMap<Integer, ChannelDto>();
            for (ChannelDto item : channelList) {
                channelMap.put(item.getChannelID(), item);
            }

            for (ChannelDto item : channelList) {
                int parentID = item.getParentID();

                // The root channel skip
                if (parentID <= 0) {
                    continue;
                }

                ChannelDto parentChannel = channelMap.get(parentID);
                parentChannel.getChildren().add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}