package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.SecurityRoleResource;

public interface SecurityRoleResourceMapper {
    int deleteByPrimaryKey(Integer roleResID);

    int insert(SecurityRoleResource record);

    int insertSelective(SecurityRoleResource record);

    SecurityRoleResource selectByPrimaryKey(Integer roleResID);

    int updateByPrimaryKeySelective(SecurityRoleResource record);

    int updateByPrimaryKey(SecurityRoleResource record);
}