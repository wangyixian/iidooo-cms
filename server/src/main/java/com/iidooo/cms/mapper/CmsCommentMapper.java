package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.CmsComment;

public interface CmsCommentMapper {
    int deleteByPrimaryKey(Integer commentID);

    int insert(CmsComment record);

    int insertSelective(CmsComment record);

    CmsComment selectByPrimaryKey(Integer commentID);

    int updateByPrimaryKeySelective(CmsComment record);

    int updateByPrimaryKey(CmsComment record);
}