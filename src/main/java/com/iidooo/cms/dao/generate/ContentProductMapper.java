package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.ContentProduct;

public interface ContentProductMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(ContentProduct record);

    int insertSelective(ContentProduct record);

    ContentProduct selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(ContentProduct record);

    int updateByPrimaryKey(ContentProduct record);
}