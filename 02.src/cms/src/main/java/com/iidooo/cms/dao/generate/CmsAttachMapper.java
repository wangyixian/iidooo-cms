package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsAttach;

public interface CmsAttachMapper {
    int deleteByPrimaryKey(Integer attachID);

    int insert(CmsAttach record);

    int insertSelective(CmsAttach record);

    CmsAttach selectByPrimaryKey(Integer attachID);

    int updateByPrimaryKeySelective(CmsAttach record);

    int updateByPrimaryKey(CmsAttach record);
}