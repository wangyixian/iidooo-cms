package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.SecurityRoleResource;

public interface SecurityRoleResourceMapper {
    int deleteByPrimaryKey(Integer roleResourceID);

    int insert(SecurityRoleResource record);

    int insertSelective(SecurityRoleResource record);

    SecurityRoleResource selectByPrimaryKey(Integer roleResourceID);

    int updateByPrimaryKeySelective(SecurityRoleResource record);

    int updateByPrimaryKey(SecurityRoleResource record);
}