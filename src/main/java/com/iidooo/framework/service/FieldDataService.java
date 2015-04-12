package com.iidooo.framework.service;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldConfigDto;
import com.iidooo.framework.dto.extend.FieldDataDto;

public interface FieldDataService {
    List<FieldDataDto> getFieldDataList(List<FieldConfigDto> fieldConfigs, int tableDataID);
}
