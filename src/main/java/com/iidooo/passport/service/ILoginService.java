package com.iidooo.passport.service;

import java.util.List;

import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;

public interface ILoginService {
    UserDto login(String loginID, String password);
    
    List<RoleDto> getUserRoleList(int userID);
}
