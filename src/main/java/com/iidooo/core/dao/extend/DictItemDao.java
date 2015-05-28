package com.iidooo.core.dao.extend;

import java.util.List;

import com.iidooo.core.dto.extend.DictItemDto;

public interface DictItemDao {
    List<DictItemDto> selectByClassCode(String dictClassCode);
}
