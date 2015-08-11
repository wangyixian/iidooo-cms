package com.iidooo.core.dao.generate;

import com.iidooo.core.dto.generate.HisVisite;

public interface HisVisiteMapper {
    int deleteByPrimaryKey(Integer hisID);

    int insert(HisVisite record);

    int insertSelective(HisVisite record);

    HisVisite selectByPrimaryKey(Integer hisID);

    int updateByPrimaryKeySelective(HisVisite record);

    int updateByPrimaryKey(HisVisite record);
}