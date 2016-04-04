package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iidooo.cms.mapper.CmsCommentMapper;
import com.iidooo.cms.mapper.CmsCommentNoticeMapper;
import com.iidooo.cms.mapper.CmsContentMapper;
import com.iidooo.cms.model.po.CmsComment;
import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.service.CommentService;
import com.iidooo.core.model.Page;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CmsCommentMapper cmsCommentMapper;

    @Autowired
    private CmsCommentNoticeMapper cmsCommentNoticeMapper;

    @Autowired
    private CmsContentMapper cmsContentMapper;

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
    @Transactional
    public boolean createComment(CmsComment cmsComment) throws Exception{
        try {
            cmsComment.setRemarks("");
            cmsComment.setCreateTime(new Date());
            cmsComment.setUpdateUserID(cmsComment.getCreateUserID());
            cmsComment.setUpdateTime(new Date());
            if (cmsCommentMapper.insert(cmsComment) <= 0) {
                throw new Exception();
            }

            // 发送一个评论通知给内容所有者或者评论相关者
            CmsContent cmsContent = cmsContentMapper.selectByContentID(cmsComment.getContentID());
            // 创建评论和该条内容的创建者不是同一个人的话，把这个评论推送给内容创建者
            if (cmsContent != null && !cmsContent.getCreateUserID().equals(cmsComment.getCreateUserID())) {
                CmsCommentNotice commentNotice = new CmsCommentNotice();
                commentNotice.setCommentID(cmsComment.getCommentID());
                commentNotice.setCreateTime(new Date());
                commentNotice.setCreateUserID(cmsComment.getCreateUserID());
                commentNotice.setRemarks("");
                commentNotice.setUpdateTime(new Date());
                commentNotice.setUpdateUserID(cmsComment.getCreateUserID());
                commentNotice.setUserID(cmsContent.getCreateUserID());

                if(cmsCommentNoticeMapper.insert(commentNotice) <= 0){
                    throw new Exception();
                }
            }

            return true;
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
