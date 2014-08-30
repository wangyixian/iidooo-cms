package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsPage;

public interface CmsPageMapper {
    int deleteByPrimaryKey(Integer pageID);

    int insert(CmsPage record);

    int insertSelective(CmsPage record);

    CmsPage selectByPrimaryKey(Integer pageID);

    int updateByPrimaryKeySelective(CmsPage record);

    int updateByPrimaryKey(CmsPage record);
}