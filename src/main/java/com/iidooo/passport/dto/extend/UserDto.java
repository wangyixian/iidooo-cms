package com.iidooo.passport.dto.extend;

import java.util.List;

import com.iidooo.passport.dto.generate.User;

public class UserDto extends User{
    private List<RoleDto> roleList;
    private String roleString;
    public List<RoleDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }

    public String getRoleString() {
        return roleString;
    }

    public void setRoleString(String roleString) {
        this.roleString = roleString;
    }
    
}
