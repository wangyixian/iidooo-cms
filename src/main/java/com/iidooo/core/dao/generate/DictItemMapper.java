package com.iidooo.core.dao.generate;

import com.iidooo.core.dto.generate.DictItem;

public interface DictItemMapper {
    int deleteByPrimaryKey(Integer dictItemID);

    int insert(DictItem record);

    int insertSelective(DictItem record);

    DictItem selectByPrimaryKey(Integer dictItemID);

    int updateByPrimaryKeySelective(DictItem record);

    int updateByPrimaryKey(DictItem record);
}