package com.iidooo.cms.admin.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.URLConstant;
import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.framework.action.BaseDetailAction;
import com.iidooo.framework.dto.extend.DictItemDto;

public class ContentDetailArticleAction extends ContentDetailAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentDetailArticleAction.class);

    private List<DictItemDto> productTypes;

    public List<DictItemDto> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<DictItemDto> productTypes) {
        this.productTypes = productTypes;
    }

    private List<DictItemDto> productCountries;

    public List<DictItemDto> getProductCountries() {
        return productCountries;
    }

    public void setProductCountries(List<DictItemDto> productCountries) {
        this.productCountries = productCountries;
    }

    private List<DictItemDto> productOrigins;

    public List<DictItemDto> getProductOrigins() {
        return productOrigins;
    }

    public void setProductOrigins(List<DictItemDto> productOrigins) {
        this.productOrigins = productOrigins;
    }

    private CmsContentProductDto product;

    public CmsContentProductDto getProduct() {
        return product;
    }

    public void setProduct(CmsContentProductDto product) {
        this.product = product;
    }

    @Override
    public String init() {
        try {
            super.init();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    @Override
    public String create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete() {
        // TODO Auto-generated method stub
        return null;
    }

}
