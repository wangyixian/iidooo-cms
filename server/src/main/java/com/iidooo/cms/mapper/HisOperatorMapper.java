package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.HisOperator;

public interface HisOperatorMapper {
    int deleteByPrimaryKey(Integer hisID);

    int insert(HisOperator record);

    int insertSelective(HisOperator record);

    HisOperator selectByPrimaryKey(Integer hisID);

    int updateByPrimaryKeySelective(HisOperator record);

    int updateByPrimaryKey(HisOperator record);
}