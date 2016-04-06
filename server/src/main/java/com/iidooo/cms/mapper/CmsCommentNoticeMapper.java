package com.iidooo.cms.mapper;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsCommentNotice;

public interface CmsCommentNoticeMapper {
    
    /**
     * 根据NoticeID这个主键删除一个评论通知
     * @param noticeID 主键ID
     * @return 删除操作所影响的行数
     */
    int deleteByPrimaryKey(Integer noticeID);
    
    /**
     * 根据CommentID 和 UserID 删除评论通知
     * @param userID 用户ID
     * @param commentID 内容ID
     * @return 删除操作所影响的行数
     */
    int deleteByCommentUserID(@Param("userID")Integer userID, @Param("commentID")Integer commentID);

    /**
     * 根据UserID这删除相关评论通知
     * @param userID 该用户ID的评论会被删除
     * @return 删除操作所影响的行数
     */
    int deleteByUserID(Integer userID);
    
    /**
     * 删除该用户ID的关于该内容ID的所有评论通知
     * @param userID 用户ID
     * @param contentID 内容ID
     * @return 删除操作所影响的行数
     */
    int deleteByUserContentID(@Param("userID")Integer userID, @Param("contentID")Integer contentID);
    
    /**
     * 创建评论通知数据
     * @param cmsCommentNotice 该评论通知对象的数据会被插入
     * @return 插入数据所影响的行数
     */
    int insert(CmsCommentNotice cmsCommentNotice);

    /**
     * 根据主键NoticeID查询评论通知
     * @param noticeID 主键NoticeID
     * @return 所获得的评论通知对象
     */
    CmsCommentNotice selectByPrimaryID(Integer noticeID);
    
    /**
     * 根据用户ID查询评论通知一览
     * @param userID 查询该用户ID的评论通知
     * @param commentID 查询该用户ID的评论通知
     * @param page 分页对象
     * @return 评论通知对象
     */
    CmsCommentNotice selectByCommentUserID(@Param("userID")Integer userID, @Param("commentID")Integer commentID);

    int updateByPrimaryKeySelective(CmsCommentNotice record);

    int updateByPrimaryKey(CmsCommentNotice record);
}