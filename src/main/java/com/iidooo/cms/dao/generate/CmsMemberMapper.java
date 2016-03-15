package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsMember;

public interface CmsMemberMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(CmsMember record);

    int insertSelective(CmsMember record);

    CmsMember selectByPrimaryKey(Integer userID);

    int updateByPrimaryKeySelective(CmsMember record);

    int updateByPrimaryKey(CmsMember record);
}