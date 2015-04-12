package com.iidooo.cms.client.action.product;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.framework.action.BaseAction;

public class ProductDetailAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductDetailAction.class);

    @Autowired
    private ContentProductService contentProductService;

    private CmsContentProductDto content;

    public CmsContentProductDto getContent() {
        return content;
    }

    public void setContent(CmsContentProductDto content) {
        this.content = content;
    }

    public String init() {
        try {
            content = contentProductService.getContentByID(content.getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
