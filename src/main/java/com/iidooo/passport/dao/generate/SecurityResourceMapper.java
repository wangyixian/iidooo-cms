package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.SecurityResource;

public interface SecurityResourceMapper {
    int deleteByPrimaryKey(Integer resourceID);

    int insert(SecurityResource record);

    int insertSelective(SecurityResource record);

    SecurityResource selectByPrimaryKey(Integer resourceID);

    int updateByPrimaryKeySelective(SecurityResource record);

    int updateByPrimaryKey(SecurityResource record);
}