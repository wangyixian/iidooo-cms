package com.iidooo.cms.client.action.index;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.action.CmsBaseAction;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.cms.service.ContentService;

public class IndexAction extends CmsBaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IndexAction.class);

    @Autowired
    private ContentService contentService;

    private List<CmsContentDto> choiceProducts;

    private List<CmsContentDto> salesProducts;

    private List<CmsContentDto> lastestArticles;

    public List<CmsContentDto> getChoiceProducts() {
        return choiceProducts;
    }

    public void setChoiceProducts(List<CmsContentDto> choiceProducts) {
        this.choiceProducts = choiceProducts;
    }

    public List<CmsContentDto> getSalesProducts() {
        return salesProducts;
    }

    public void setSalesProducts(List<CmsContentDto> salesProducts) {
        this.salesProducts = salesProducts;
    }

    public List<CmsContentDto> getLastestArticles() {
        return lastestArticles;
    }

    public void setLastestArticles(List<CmsContentDto> lastestArticles) {
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
