package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.DictClass;

public interface DictClassMapper {
    int deleteByPrimaryKey(Integer dictClassID);

    int insert(DictClass record);

    int insertSelective(DictClass record);

    DictClass selectByPrimaryKey(Integer dictClassID);

    int updateByPrimaryKeySelective(DictClass record);

    int updateByPrimaryKey(DictClass record);
}