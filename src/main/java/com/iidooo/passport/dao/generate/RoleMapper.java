package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleID);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleID);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}