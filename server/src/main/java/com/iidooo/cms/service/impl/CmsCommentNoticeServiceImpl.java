package com.iidooo.cms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.CmsCommentNoticeMapper;
import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.cms.service.CmsCommentNoticeService;

@Service
public class CmsCommentNoticeServiceImpl implements CmsCommentNoticeService {
    private static final Logger logger = Logger.getLogger(CmsCommentNoticeServiceImpl.class);

    @Autowired
    private CmsCommentNoticeMapper cmsCommentNoticeMapper;
    
    @Override
    public CmsCommentNotice getCommentNotice(Integer userID, Integer commentID){
        try {
            CmsCommentNotice result = cmsCommentNoticeMapper.selectByCommentUserID(userID, commentID);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
    
    @Override
    public boolean deleteCommentNotice(Integer userID, Integer commentID) {
        try {
            boolean result = false;
            if (cmsCommentNoticeMapper.deleteByCommentUserID(userID, commentID) > 0) {
                return true;
            } 
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public boolean deleteCommentNoticeList(Integer userID) {
        try {
            if(cmsCommentNoticeMapper.deleteByUserID(userID) <= 0){
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
    
    @Override
    public boolean deleteCommentNoticeList(Integer userID, Integer contentID){
        try {
            if(cmsCommentNoticeMapper.deleteByUserContentID(userID, contentID) <= 0){
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }
}
