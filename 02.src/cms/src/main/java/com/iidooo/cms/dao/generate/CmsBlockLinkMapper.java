package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsBlockLink;

public interface CmsBlockLinkMapper {
    int deleteByPrimaryKey(Integer blockLinkID);

    int insert(CmsBlockLink record);

    int insertSelective(CmsBlockLink record);

    CmsBlockLink selectByPrimaryKey(Integer blockLinkID);

    int updateByPrimaryKeySelective(CmsBlockLink record);

    int updateByPrimaryKey(CmsBlockLink record);
}