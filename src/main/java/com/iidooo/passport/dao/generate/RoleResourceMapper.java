package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.RoleResource;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Integer roleResourceID);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Integer roleResourceID);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
}