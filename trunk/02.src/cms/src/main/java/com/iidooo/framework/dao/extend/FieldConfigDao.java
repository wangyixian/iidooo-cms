package com.iidooo.framework.dao.extend;

import java.util.List;

import com.iidooo.framework.dto.extend.FieldConfigDto;

public interface FieldConfigDao {
    List<FieldConfigDto> selectByModelID(int modelID);
}
