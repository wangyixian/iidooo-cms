package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class SecurityRoleResource extends BaseDto{
    private Integer roleResourceID;

    private Integer roleID;

    private String resourceID;

    public Integer getRoleResourceID() {
        return roleResourceID;
    }

    public void setRoleResourceID(Integer roleResourceID) {
        this.roleResourceID = roleResourceID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID == null ? null : resourceID.trim();
    }
}