package com.iidooo.cms.client.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.cms.dao.extend.CmsContentArticleDao;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.framework.constant.SpringConstant;
import com.iidooo.framework.utility.SpringUtil;

public class ArticleListTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(ArticleListTag.class);

    private int channelID;

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    private String blockTitle;

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    private int articleType;

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    private int count = 5;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private boolean isShowImage = false;
    
    public boolean isShowImage() {
        return isShowImage;
    }

    public void setShowImage(boolean isShowImage) {
        this.isShowImage = isShowImage;
    }

    @Override
    public void doTag() throws JspException, IOException {
        logger.debug("BlockArticleTag doTag method execute start.");
        PageContext pageContext = null;
        JspWriter out = null;
        try {
            pageContext = (PageContext) getJspContext();
            out = pageContext.getOut();

            ServletContext sc = pageContext.getServletContext();
            CmsContentArticleDao cmsContentArticleDao = (CmsContentArticleDao) SpringUtil.getBean(sc, SpringConstant.CMS_CONTENT_ARTICLE_DAO);

            List<CmsContentArticleDto> articles = cmsContentArticleDao.selectContentArticles(channelID, articleType, count);
            out.println("<div class='block'>");
            out.println("<div class='block_title'>");
            out.println(blockTitle);
            out.println("</div>");
            out.println("<div class='block_content'>");
            out.println("<ul>");
            for (CmsContentArticleDto item : articles) {
                out.println("<li>");
                out.println("<div class='block_content_item'>");
                
                if (isShowImage) {
                    out.println("<span>");               
                    out.println("<img alt='" + item.getContentTitle() + "' src='" + item.getContentImageTitle() + "'>"); 
                    out.println("</span>");
                }
                
                out.println("<span class='block_content_item_title'>"); 
                out.println(item.getContentTitle());
                out.println("</span>");
                
                out.println("<span class='block_content_item_date'>");
                out.println(item.getUpdateDate());
                out.println("</span>");
                
                out.println("</div>");            
                out.println("</li>");
            }
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            logger.debug("BlockArticleTag doTag method execute end.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
