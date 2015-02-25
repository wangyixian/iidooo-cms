package com.iidooo.cms.client.action.blog;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.action.product.ProductDetailAction;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.service.ContentArticleService;
import com.iidooo.framework.action.BaseAction;

public class BlogDetailAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BlogDetailAction.class);

    @Autowired
    private ContentArticleService contentArticleService;

    private CmsContentArticleDto content;

    public CmsContentArticleDto getContent() {
        return content;
    }

    public void setContent(CmsContentArticleDto content) {
        this.content = content;
    }

    public String init() {
        try {
            content = contentArticleService.getContentByID(content.getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
