package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleID);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleID);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}