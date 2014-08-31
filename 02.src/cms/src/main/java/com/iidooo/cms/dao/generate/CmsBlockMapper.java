package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsBlock;

public interface CmsBlockMapper {
    int deleteByPrimaryKey(Integer blockID);

    int insert(CmsBlock record);

    int insertSelective(CmsBlock record);

    CmsBlock selectByPrimaryKey(Integer blockID);

    int updateByPrimaryKeySelective(CmsBlock record);

    int updateByPrimaryKey(CmsBlock record);
}