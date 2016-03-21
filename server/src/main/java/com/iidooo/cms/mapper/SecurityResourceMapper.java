package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.SecurityResource;

public interface SecurityResourceMapper {
    int deleteByPrimaryKey(Integer resID);

    int insert(SecurityResource record);

    int insertSelective(SecurityResource record);

    SecurityResource selectByPrimaryKey(Integer resID);

    int updateByPrimaryKeySelective(SecurityResource record);

    int updateByPrimaryKey(SecurityResource record);
}