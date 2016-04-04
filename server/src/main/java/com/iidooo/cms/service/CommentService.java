package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.core.model.Page;

public interface CommentService {
    List<CmsComment> getCommentListByContentID(Integer contentID, Page page);
    
    /**
     * 根据CommentID获取一条评论
     * @param commentID 获取该ID的评论
     * @return 获取的评论对象
     */
    CmsComment getCommentByID(Integer commentID);
    
    /**
     * 创建一条评论
     * @param cmsComment 创建的评论对象
     * @return 创建成功或者失败
     * @throws Exception 抛出的未处理异常
     */
    boolean createComment(CmsComment cmsComment) throws Exception;
    
    /**
     * 更新一条评论
     * @param cmsComment 要更新的评论对象
     * @return 更新的评论
     */
    CmsComment updateComment(CmsComment cmsComment);
}
