package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.core.model.Page;

public interface CmsCommentMapper {
    int deleteByPrimaryKey(Integer commentID);

    /**
     * 插入CmsComment数据
     * @param cmsComment 该条记录被插入
     * @return 影响的行数
     */
    int insert(CmsComment cmsComment);

    /**
     * 通过主键查询CmsComment数据
     * @param commentID 主键ID
     * @return 查询获得的CmsComment对象
     */
    CmsComment selectByCommentID(Integer commentID);
    
    /**
     * 通过备注的信息查找
     * @param createUserID 创建者的ID
     * @param contentID 内容ID
     * @param comment 备注信息
     * @return 查询获得的CmsComment对象
     */
    CmsComment selectByCommentInfo(@Param("createUserID")Integer createUserID, @Param("contentID")Integer contentID, @Param("comment")String comment);
    
    /**
     * 得到内容的评论数
     * @param contentID 指定内容的评论数
     * @return 评论数
     */
    int selectCommentCount(Integer contentID);
    
    /**
     * 根据内容ID获得关联的评论一览
     * @param contentID 内容ID
     * @param page 分页对象
     * @return 评论一览列表
     */
    List<CmsComment> selectByContentID(@Param("contentID")Integer contentID, @Param("page")Page page);

    /**
     * 根据用户ID获得关联的评论一览，从通知表中获得
     * @param userID 用户ID
     * @param page 分页对象
     * @return 评论一览列表
     */
    List<CmsComment> selectByUserID(@Param("userID")Integer userID, @Param("page")Page page);
    
    /**
     * 更新CmsComment数据
     * @param 要更新的 CmsComment 对象内容
     * @return 更新所影响的行
     */
    int updateByCommentID(CmsComment cmsComment);
    
}