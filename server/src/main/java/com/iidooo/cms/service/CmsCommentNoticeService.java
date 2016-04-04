package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.core.model.Page;

public interface CmsCommentNoticeService {
    List<CmsCommentNotice> getCommentNoticeList(Integer userID, Page page);
    
    CmsCommentNotice getCommentNotice(Integer noticeID) throws Exception;
    
    boolean deleteCommentNoticeList(Integer userID);
}
