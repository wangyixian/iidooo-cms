package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.FieldConfig;

public interface FieldConfigMapper {
    int deleteByPrimaryKey(Integer fieldID);

    int insert(FieldConfig record);

    int insertSelective(FieldConfig record);

    FieldConfig selectByPrimaryKey(Integer fieldID);

    int updateByPrimaryKeySelective(FieldConfig record);

    int updateByPrimaryKey(FieldConfig record);
}