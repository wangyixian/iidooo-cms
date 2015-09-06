package com.iidooo.passport.service.security;

import java.util.List;

import com.iidooo.passport.dto.extend.ResourceDto;
import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;

public interface LoginService {
    UserDto login(String loginID, String password);
    
    List<RoleDto> getUserRoleList(int userID);
    
    List<ResourceDto> getUserResourceList(List<RoleDto> roles);
}
