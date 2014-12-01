package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsContentTag;

public interface CmsContentTagMapper {
    int deleteByPrimaryKey(Integer tagID);

    int insert(CmsContentTag record);

    int insertSelective(CmsContentTag record);

    CmsContentTag selectByPrimaryKey(Integer tagID);

    int updateByPrimaryKeySelective(CmsContentTag record);

    int updateByPrimaryKey(CmsContentTag record);
}