package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.SecurityUserRole;

public interface SecurityUserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleID);

    int insert(SecurityUserRole record);

    int insertSelective(SecurityUserRole record);

    SecurityUserRole selectByPrimaryKey(Integer userRoleID);

    int updateByPrimaryKeySelective(SecurityUserRole record);

    int updateByPrimaryKey(SecurityUserRole record);
}