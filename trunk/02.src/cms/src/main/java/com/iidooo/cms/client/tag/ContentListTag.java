package com.iidooo.cms.client.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.CmsContentDao;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.constant.DBConstant;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.constant.SpringConstant;
import com.iidooo.framework.dto.base.PagingDto;
import com.iidooo.framework.utility.SpringUtil;

public class ContentListTag extends SimpleTagSupport {
    private static final Logger logger = Logger.getLogger(ContentListTag.class);

    private String channelPath;
    
    private String action;

    private int pageStart = 0;

    private int pageSize = 5;

    private boolean isShowImage = false;

    private boolean isShowDate = false;
    
    private String sortField = DBConstant.FIELD_SEQUENCE;
    
    private String sortType = DBConstant.SORT_TYPE_ASC;

    public String getChannelPath() {
        return channelPath;
    }

    public void setChannelPath(String channelPath) {
        this.channelPath = channelPath;
    }

    

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getIsShowImage() {
        return isShowImage;
    }

    public void setIsShowImage(boolean isShowImage) {
        this.isShowImage = isShowImage;
    }

    public boolean getIsShowDate() {
        return isShowDate;
    }

    public void setIsShowDate(boolean isShowDate) {
        this.isShowDate = isShowDate;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public void doTag() throws JspException, IOException {
        logger.debug("ContentListTag doTag method execute start.");
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            ServletContext sc = pageContext.getServletContext();
            CmsContentDao cmsContentDao = (CmsContentDao) SpringUtil.getBean(sc, SpringConstant.CMS_CONTENT_DAO);

            PagingDto page = new PagingDto();
            page.setStart(pageStart);
            page.setPageSize(pageSize);
            page.setSortField(sortField);
            page.setSortType(sortType);
            
            List<CmsContentDto> contents = cmsContentDao.selectByChannelPath(channelPath, page);

            for (CmsContentDto item : contents) {
                out.println("<li>");
                out.println("<div class='block_content_item'>");

                if (isShowImage) {
                    out.println("<div class='block_content_item_image'>");
                    out.println("<a target='_blank' href='" + action + "?content.contentID=" + item.getContentID() + "'>");
                    out.println("<img alt='" + item.getContentTitle() + "' src='" + item.getContentImageTitle() + "'>");
                    out.println("</a>");
                    out.println("</div>");
                }

                out.println("<div class='block_content_item_title'>");
                out.println("<a target='_blank' href='" + action + "?content.contentID=" + item.getContentID() + "'>");
                out.println(item.getContentTitle());
                out.println("</a>");
                out.println("</div>");

                if (isShowDate) {
                    out.println("<div class='block_content_item_date'>");
                    out.println(item.getUpdateDate());
                    out.println("</div>");
                }

                out.println("</div>");
                out.println("</li>");
            }
            logger.debug("ContentListTag doTag method execute end.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
