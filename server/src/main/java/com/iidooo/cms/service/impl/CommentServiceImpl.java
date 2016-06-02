package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.iidooo.core.mapper.SecurityUserMapper;
import com.iidooo.core.model.Page;
import com.iidooo.core.model.po.SecurityUser;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CmsCommentMapper cmsCommentMapper;

    @Autowired
    private CmsCommentNoticeMapper cmsCommentNoticeMapper;

    @Autowired
    private CmsContentMapper cmsContentMapper;
    
    @Autowired
    private SecurityUserMapper securityUserMapper;

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
    public List<CmsComment> getNoticeCommentListByUserID(Integer userID, Page page) {
        try {
            List<CmsComment> result = new ArrayList<CmsComment>();
            result = cmsCommentMapper.selectByUserID(userID, page);
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
    public CmsComment getCommentByInfo(Integer createUserID, Integer contentID, String comment) {
        try {
            CmsComment result = cmsCommentMapper.selectByCommentInfo(createUserID, contentID, comment);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean createComment(CmsComment cmsComment) throws Exception {
        try {
            if (cmsCommentMapper.insert(cmsComment) <= 0) {
                throw new Exception();
            }

            // 发送一个评论通知给内容所有者或者评论相关者
            CmsContent cmsContent = cmsContentMapper.selectByContentID(cmsComment.getContentID());

            // 管理员不需要收到评论，所以首先要获取所有的管理员
            // Key: UserID; Value: SecurityUser
            HashMap<Integer, SecurityUser> adminIDMap = new HashMap<Integer, SecurityUser>();
            SecurityUser securityUser = new SecurityUser();
            securityUser.setUserType("1");
            List<SecurityUser> administrators = securityUserMapper.selectForSearch(securityUser);
            for (SecurityUser item : administrators) {
                adminIDMap.put(item.getUserID(), item);
            }
            
            // 创建评论和该条内容的创建者不是同一个人的话，把这个评论推送给内容创建者
            if (cmsContent != null) {
                List<CmsComment> cmsCommentList = cmsCommentMapper.selectByContentID(cmsContent.getContentID(), null);

                // 记录本次推送过的用户ID列表，以免重复推送
                List<Integer> noticedUserList = new ArrayList<Integer>();
                // 评论者自己先不用受到通知
                noticedUserList.add(cmsComment.getCreateUserID());
                // 如果不是内容创建者自己的评论，那么先给内容创建者发一条通知推送
                if (!adminIDMap.containsKey(cmsContent.getCreateUserID()) && 
                        !cmsContent.getCreateUserID().equals(cmsComment.getCreateUserID())) {
                    CmsCommentNotice commentNotice = new CmsCommentNotice();
                    commentNotice.setUserID(cmsContent.getCreateUserID());
                    commentNotice.setContentID(cmsComment.getContentID());
                    commentNotice.setCommentID(cmsComment.getCommentID());
                    commentNotice.setCreateTime(new Date());
                    commentNotice.setCreateUserID(cmsComment.getCreateUserID());
                    commentNotice.setUpdateTime(new Date());
                    commentNotice.setUpdateUserID(cmsComment.getCreateUserID());

                    if (cmsCommentNoticeMapper.insert(commentNotice) <= 0) {
                        throw new Exception();
                    } else {
                        noticedUserList.add(commentNotice.getUserID());
                    }
                }

                // 其他评论者也要被推送
                for (CmsComment item : cmsCommentList) {

                    // 推送过的不重复推送
                    if (noticedUserList.contains(item.getCreateUserID())) {
                        continue;
                    }
                    
                    // 管理员不被推送
                    if (adminIDMap.containsKey(item.getCreateUserID())){
                        continue;
                    }
                    
                    CmsCommentNotice commentNotice = new CmsCommentNotice();
                    commentNotice.setUserID(item.getCreateUserID());
                    commentNotice.setContentID(cmsComment.getContentID());
                    commentNotice.setCommentID(cmsComment.getCommentID());
                    commentNotice.setCreateTime(new Date());
                    commentNotice.setCreateUserID(cmsComment.getCreateUserID());
                    commentNotice.setUpdateTime(new Date());
                    commentNotice.setUpdateUserID(cmsComment.getCreateUserID());

                    if (cmsCommentNoticeMapper.insert(commentNotice) <= 0) {
                        throw new Exception();
                    } else {
                        noticedUserList.add(commentNotice.getUserID());
                    }
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
