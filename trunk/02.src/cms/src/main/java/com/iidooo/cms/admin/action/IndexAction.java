package com.iidooo.cms.admin.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.framework.action.BaseAction;

public class IndexAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IndexAction.class);

    @Autowired
    private ContentProductService contentProductService;
    
    private List<CmsContentProductDto> choiceProducts;

    private List<CmsContentProductDto> salesProducts;

    private List<CmsContentArticleDto> lastestArticles;

    public List<CmsContentProductDto> getChoiceProducts() {
        return choiceProducts;
    }

    public void setChoiceProducts(List<CmsContentProductDto> choiceProducts) {
        this.choiceProducts = choiceProducts;
    }

    public List<CmsContentProductDto> getSalesProducts() {
        return salesProducts;
    }

    public void setSalesProducts(List<CmsContentProductDto> salesProducts) {
        this.salesProducts = salesProducts;
    }

    public List<CmsContentArticleDto> getLastestArticles() {
        return lastestArticles;
    }

    public void setLastestArticles(List<CmsContentArticleDto> lastestArticles) {
        this.lastestArticles = lastestArticles;
    }

    public String init() {
        try {
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
