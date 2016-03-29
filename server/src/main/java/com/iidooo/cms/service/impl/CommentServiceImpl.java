package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public CmsComment getCommentByID(Integer commentID) {
        try {
            CmsComment result = cmsCommentMapper.selectByCommentID(commentID);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public CmsComment createComment(CmsComment cmsComment) {

        try {
            cmsComment.setRemarks("");
            cmsComment.setCreateTime(new Date());
            cmsComment.setUpdateUserID(cmsComment.getCreateUserID());
            cmsComment.setUpdateTime(new Date());
            if (cmsCommentMapper.insert(cmsComment) <= 0) {
                return null;
            }
            
            return cmsCommentMapper.selectByCommentID(cmsComment.getCommentID());
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public CmsComment updateComment(CmsComment cmsComment) {
        try {
            cmsComment.setUpdateUserID(cmsComment.getCreateUserID());
            cmsComment.setUpdateTime(new Date());
            if (cmsCommentMapper.updateByCommentID(cmsComment) <= 0) {
                return null;
            }
            cmsComment = cmsCommentMapper.selectByCommentID(cmsComment.getCommentID());

            return cmsComment;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
}
