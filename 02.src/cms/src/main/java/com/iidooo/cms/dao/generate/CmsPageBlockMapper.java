package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsPageBlock;

public interface CmsPageBlockMapper {
    int deleteByPrimaryKey(Integer pageBlockID);

    int insert(CmsPageBlock record);

    int insertSelective(CmsPageBlock record);

    CmsPageBlock selectByPrimaryKey(Integer pageBlockID);

    int updateByPrimaryKeySelective(CmsPageBlock record);

    int updateByPrimaryKey(CmsPageBlock record);
}