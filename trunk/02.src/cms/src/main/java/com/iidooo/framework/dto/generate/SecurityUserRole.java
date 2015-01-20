package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class SecurityUserRole extends BaseDto{
    private Integer userRoleID;

    private Integer userID;

    private Integer roleID;

    public Integer getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(Integer userRoleID) {
        this.userRoleID = userRoleID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

}