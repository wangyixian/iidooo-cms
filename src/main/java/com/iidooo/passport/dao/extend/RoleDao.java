package com.iidooo.passport.dao.extend;

import java.util.List;

import com.iidooo.passport.dto.extend.RoleDto;
import com.iidooo.passport.dto.extend.UserDto;

public interface RoleDao {

    List<RoleDto> selectSecurityRoleList(UserDto securityUser);

}