package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldConfigDto;

public interface FieldConfigService {
    List<FieldConfigDto> getFieldConfigList(int modelID);
}
