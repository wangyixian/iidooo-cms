package com.iidooo.cms.dto.generate;

import com.iidooo.cms.dto.extend.CmsContentDto;

public class CmsContentProduct extends CmsContentDto{

    private Integer productType;

    private Integer productCountry;

    private Integer productOrigin;

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(Integer productCountry) {
        this.productCountry = productCountry;
    }

    public Integer getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(Integer productOrigin) {
        this.productOrigin = productOrigin;
    }
}