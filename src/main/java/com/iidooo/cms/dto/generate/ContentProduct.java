package com.iidooo.cms.dto.generate;

public class ContentProduct {
    private Integer contentID;

    private String productCountry;

    private String productOrigin;

    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
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