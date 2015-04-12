package com.iidooo.framework.dto.extend;

import com.iidooo.framework.dto.generate.SecurityUser;

public class SecurityUserDto extends SecurityUser {

    private int roleID;

    private String roleName;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
