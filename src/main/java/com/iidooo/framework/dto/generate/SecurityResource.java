package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class SecurityResource extends BaseDto{
    private Integer resourceID;

    private Integer parentResourceID;

    private String resourceName;

    private String resourceURL;

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public Integer getParentResourceID() {
        return parentResourceID;
    }

    public void setParentResourceID(Integer parentResourceID) {
        this.parentResourceID = parentResourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceURL() {
        return resourceURL;
    }

    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL == null ? null : resourceURL.trim();
    }

}