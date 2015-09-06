package com.iidooo.passport.dao.extend;

import java.util.List;

import com.iidooo.passport.dto.extend.ResourceDto;
import com.iidooo.passport.dto.extend.RoleDto;

public interface ResourceDao {
    List<ResourceDto> selectAll();
    
    List<ResourceDto> selectResourceListByRoles(List<RoleDto> roles);
}
