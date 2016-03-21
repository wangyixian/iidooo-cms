package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.core.model.Page;

public interface CmsCommentMapper {
    int deleteByPrimaryKey(Integer commentID);

    int insert(CmsComment record);

    int insertSelective(CmsComment record);

    CmsComment selectByPrimaryKey(Integer commentID);

    int updateByPrimaryKeySelective(CmsComment record);

    int updateByPrimaryKey(CmsComment record);
    
    /**
     * 根据内容ID获得关联的评论一览
     * @param contentID
     * @param page 分页对象
     * @return 评论一览列表
     */
    List<CmsComment> selectByContentID(@Param("contentID")Integer contentID, @Param("page")Page page);
}