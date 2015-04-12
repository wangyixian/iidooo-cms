package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsContentArticle;

public interface CmsContentArticleMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContentArticle record);

    int insertSelective(CmsContentArticle record);

    CmsContentArticle selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(CmsContentArticle record);

    int updateByPrimaryKey(CmsContentArticle record);
}