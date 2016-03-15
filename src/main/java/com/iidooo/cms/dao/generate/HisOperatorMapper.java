package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.HisOperator;

public interface HisOperatorMapper {
    int deleteByPrimaryKey(Integer hisID);

    int insert(HisOperator record);

    int insertSelective(HisOperator record);

    HisOperator selectByPrimaryKey(Integer hisID);

    int updateByPrimaryKeySelective(HisOperator record);

    int updateByPrimaryKey(HisOperator record);
}