package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldModelDto;
import com.iidooo.framework.enumeration.TableName;

public interface FieldModelService {
    List<FieldModelDto> getFieldModelList(TableName tableName);
}
