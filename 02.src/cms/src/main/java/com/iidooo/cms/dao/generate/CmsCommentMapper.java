package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsComment;

public interface CmsCommentMapper {
    int deleteByPrimaryKey(Integer commentID);

    int insert(CmsComment record);

    int insertSelective(CmsComment record);

    CmsComment selectByPrimaryKey(Integer commentID);

    int updateByPrimaryKeySelective(CmsComment record);

    int updateByPrimaryKeyWithBLOBs(CmsComment record);

    int updateByPrimaryKey(CmsComment record);
}