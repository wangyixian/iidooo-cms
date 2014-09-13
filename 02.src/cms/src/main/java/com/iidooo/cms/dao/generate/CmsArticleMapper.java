package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsArticle;

public interface CmsArticleMapper {
    int deleteByPrimaryKey(Integer articleID);

    int insert(CmsArticle record);

    int insertSelective(CmsArticle record);

    CmsArticle selectByPrimaryKey(Integer articleID);

    int updateByPrimaryKeySelective(CmsArticle record);

    int updateByPrimaryKeyWithBLOBs(CmsArticle record);

    int updateByPrimaryKey(CmsArticle record);
}