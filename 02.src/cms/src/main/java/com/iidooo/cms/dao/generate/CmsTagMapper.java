package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsTag;

public interface CmsTagMapper {
    int deleteByPrimaryKey(Integer tagID);

    int insert(CmsTag record);

    int insertSelective(CmsTag record);

    CmsTag selectByPrimaryKey(Integer tagID);

    int updateByPrimaryKeySelective(CmsTag record);

    int updateByPrimaryKey(CmsTag record);
}