package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.CmsCommentMapper;
import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.cms.service.CommentService;
import com.iidooo.core.model.Page;

@Service
public class CommentServiceImpl implements CommentService {
    
    private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);
    
    @Autowired
    private CmsCommentMapper cmsCommentMapper;
    
    @Override
    public List<CmsComment> getCommentListByContentID(Integer contentID, Page page) {
        try {
            List<CmsComment> result = new ArrayList<CmsComment>();
            result = cmsCommentMapper.selectByContentID(contentID, page);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
    
}
