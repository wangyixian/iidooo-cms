package com.iidooo.core.api.service;

import java.util.List;

import com.iidooo.core.dto.extend.DictItemDto;

public interface IDictItemService {
    List<DictItemDto> getDictItemList(String dictClassCode);
}
