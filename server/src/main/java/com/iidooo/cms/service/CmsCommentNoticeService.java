package com.iidooo.cms.service;

import com.iidooo.cms.model.po.CmsCommentNotice;


public interface CmsCommentNoticeService {
    
    CmsCommentNotice getCommentNotice(Integer userID, Integer commentID);
    
    boolean deleteCommentNotice(Integer userID, Integer commentID);
    
    boolean deleteCommentNoticeList(Integer userID);
    
    boolean deleteCommentNoticeList(Integer userID, Integer contentID);
}
