package com.iidooo.passport.dto.generate;

public class RoleResource {
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