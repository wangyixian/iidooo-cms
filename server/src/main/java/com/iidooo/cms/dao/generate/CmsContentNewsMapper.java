package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsContentNews;

public interface CmsContentNewsMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContentNews record);

    int insertSelective(CmsContentNews record);

    CmsContentNews selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(CmsContentNews record);

    int updateByPrimaryKey(CmsContentNews record);
}