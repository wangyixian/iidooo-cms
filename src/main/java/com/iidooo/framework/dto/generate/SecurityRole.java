package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class SecurityRole extends BaseDto{
    private Integer roleID;

    private String roleName;

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

}