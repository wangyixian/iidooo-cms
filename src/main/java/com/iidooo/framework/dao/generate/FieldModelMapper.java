package com.iidooo.framework.dao.generate;

import com.iidooo.framework.dto.generate.FieldModel;

public interface FieldModelMapper {
    int deleteByPrimaryKey(Integer modelID);

    int insert(FieldModel record);

    int insertSelective(FieldModel record);

    FieldModel selectByPrimaryKey(Integer modelID);

    int updateByPrimaryKeySelective(FieldModel record);

    int updateByPrimaryKey(FieldModel record);
}