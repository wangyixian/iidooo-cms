package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.Content;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
}