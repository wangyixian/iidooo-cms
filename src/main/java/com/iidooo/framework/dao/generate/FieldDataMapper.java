package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.FieldData;

public interface FieldDataMapper {
    int deleteByPrimaryKey(Integer dataID);

    int insert(FieldData record);

    int insertSelective(FieldData record);

    FieldData selectByPrimaryKey(Integer dataID);

    int updateByPrimaryKeySelective(FieldData record);

    int updateByPrimaryKey(FieldData record);
}