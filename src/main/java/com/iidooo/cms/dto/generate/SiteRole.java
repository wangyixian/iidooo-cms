package com.iidooo.cms.dto.generate;

public class SiteRole {
    private Integer siteRoleID;

    private Integer siteID;

    private Integer roleID;

    public Integer getSiteRoleID() {
        return siteRoleID;
    }

    public void setSiteRoleID(Integer siteRoleID) {
        this.siteRoleID = siteRoleID;
    }

    public Integer getSiteID() {
        return siteID;
    }

    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
}