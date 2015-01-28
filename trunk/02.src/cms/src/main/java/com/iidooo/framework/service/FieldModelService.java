package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldModelDto;

public interface FieldModelService {
    List<FieldModelDto> getByModelType(int modelType);
}
