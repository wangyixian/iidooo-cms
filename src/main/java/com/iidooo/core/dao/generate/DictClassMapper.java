package com.iidooo.core.dao.generate;

import com.iidooo.core.dto.generate.DictClass;

public interface DictClassMapper {
    int deleteByPrimaryKey(Integer dictClassID);

    int insert(DictClass record);

    int insertSelective(DictClass record);

    DictClass selectByPrimaryKey(Integer dictClassID);

    int updateByPrimaryKeySelective(DictClass record);

    int updateByPrimaryKey(DictClass record);
}