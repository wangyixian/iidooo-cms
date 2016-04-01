package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.CmsTag;

public interface CmsTagMapper {
    int deleteByPrimaryKey(Integer tagID);

    int insert(CmsTag record);

    int insertSelective(CmsTag record);

    CmsTag selectByPrimaryKey(Integer tagID);

    int updateByPrimaryKeySelective(CmsTag record);

    int updateByPrimaryKey(CmsTag record);
}