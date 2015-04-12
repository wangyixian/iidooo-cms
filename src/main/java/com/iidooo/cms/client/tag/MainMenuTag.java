package com.iidooo.cms.client.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dao.extend.CmsChannelDao;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.framework.constant.SpringConstant;
import com.iidooo.framework.utility.SpringUtil;
import com.iidooo.framework.utility.StringUtil;

public class MainMenuTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(MainMenuTag.class);

    private String channelPath;


    public String getChannelPath() {
        return channelPath;
    }


    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
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
            CmsChannelDao cmsChannelDao = (CmsChannelDao) SpringUtil.getBean(sc, SpringConstant.CMS_CHANNEL_DAO);
            
            List<CmsChannelDto> channels = cmsChannelDao.selectByParentID(0);
            out.println("<ul id='mainmenu'>");

            for (CmsChannelDto item : channels) {
                out.println(" <li>");
                String url = StringUtil.replace(URLConstant.CHANNEL_PATH, item.getChannelPath(), item.getChannelID().toString());
                if (channelPath != null && item.getChannelPath().equals(channelPath)) {
                    out.println("<a href='" + url + "'" + " class='focus'>");
                    out.println(item.getChannelName());
                    out.println("</a>");
                } else {
                    out.println("<a href='" + url + "'>");
                    out.println(item.getChannelName());
                    out.println("</a>");
                }
                out.println("</li>");
            }
            out.println("</ul>");
            logger.debug("MainMenuTag doTag method execute end.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
