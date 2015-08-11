package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.ContentBlog;

public interface ContentBlogMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(ContentBlog record);

    int insertSelective(ContentBlog record);

    ContentBlog selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(ContentBlog record);

    int updateByPrimaryKey(ContentBlog record);
}