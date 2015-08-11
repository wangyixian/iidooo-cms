package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentID);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentID);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}