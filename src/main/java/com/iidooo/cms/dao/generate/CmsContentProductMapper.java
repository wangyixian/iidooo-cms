package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsContentProduct;

public interface CmsContentProductMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContentProduct record);

    int insertSelective(CmsContentProduct record);

    CmsContentProduct selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(CmsContentProduct record);

    int updateByPrimaryKey(CmsContentProduct record);
}