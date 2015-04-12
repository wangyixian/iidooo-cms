package com.iidooo.cms.dto.generate;

import com.iidooo.cms.dto.extend.CmsContentDto;

public class CmsContentProduct extends CmsContentDto{

    private String productType;

    private String productCountry;

    private String productOrigin;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(String productCountry) {
        this.productCountry = productCountry == null ? null : productCountry.trim();
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin == null ? null : productOrigin.trim();
    }
}