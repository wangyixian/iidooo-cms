package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(Integer userID);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);
}