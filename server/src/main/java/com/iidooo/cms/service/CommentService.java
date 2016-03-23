package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.core.model.Page;

public interface CommentService {
    List<CmsComment> getCommentListByContentID(Integer contentID, Page page);
}
