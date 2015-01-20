package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsContent;

public interface CmsContentMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContent record);

    int insertSelective(CmsContent record);

    CmsContent selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(CmsContent record);

    int updateByPrimaryKeyWithBLOBs(CmsContent record);

    int updateByPrimaryKey(CmsContent record);
}