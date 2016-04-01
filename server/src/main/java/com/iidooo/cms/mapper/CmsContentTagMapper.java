package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.CmsContentTag;

public interface CmsContentTagMapper {
    int deleteByPrimaryKey(Integer contentTagID);

    int insert(CmsContentTag record);

    int insertSelective(CmsContentTag record);

    CmsContentTag selectByPrimaryKey(Integer contentTagID);

    int updateByPrimaryKeySelective(CmsContentTag record);

    int updateByPrimaryKey(CmsContentTag record);
}