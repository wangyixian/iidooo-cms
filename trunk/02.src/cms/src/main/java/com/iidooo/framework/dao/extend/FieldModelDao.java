package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldModelDto;

public interface FieldModelDao {
    List<FieldModelDto> selectByTableName(String tableName);
}
