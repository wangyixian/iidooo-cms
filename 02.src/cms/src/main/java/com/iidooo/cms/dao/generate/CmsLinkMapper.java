package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsLink;

public interface CmsLinkMapper {
    int deleteByPrimaryKey(Integer linkID);

    int insert(CmsLink record);

    int insertSelective(CmsLink record);

    CmsLink selectByPrimaryKey(Integer linkID);

    int updateByPrimaryKeySelective(CmsLink record);

    int updateByPrimaryKey(CmsLink record);
}