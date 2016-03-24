package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.SecurityClient;

public interface SecurityClientMapper {
    int deleteByPrimaryKey(Integer clientID);

    int insert(SecurityClient record);

    int insertSelective(SecurityClient record);

    SecurityClient selectByPrimaryKey(Integer clientID);

    int updateByPrimaryKeySelective(SecurityClient record);

    int updateByPrimaryKey(SecurityClient record);
}