package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.SecurityRole;

public interface SecurityRoleMapper {
    int deleteByPrimaryKey(Integer roleID);

    int insert(SecurityRole record);

    int insertSelective(SecurityRole record);

    SecurityRole selectByPrimaryKey(Integer roleID);

    int updateByPrimaryKeySelective(SecurityRole record);

    int updateByPrimaryKey(SecurityRole record);
}