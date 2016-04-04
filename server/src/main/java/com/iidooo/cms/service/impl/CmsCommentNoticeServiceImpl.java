package com.iidooo.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iidooo.cms.mapper.CmsCommentNoticeMapper;
import com.iidooo.cms.model.po.CmsCommentNotice;
import com.iidooo.cms.service.CmsCommentNoticeService;
import com.iidooo.core.model.Page;

@Service
public class CmsCommentNoticeServiceImpl implements CmsCommentNoticeService {
    private static final Logger logger = Logger.getLogger(CmsCommentNoticeServiceImpl.class);

    @Autowired
    private CmsCommentNoticeMapper cmsCommentNoticeMapper;
    
    @Override
    public List<CmsCommentNotice> getCommentNoticeList(Integer userID, Page page) {
        try {
            List<CmsCommentNotice> result = new ArrayList<CmsCommentNotice>();
            result = cmsCommentNoticeMapper.selectByUserID(userID, page);
            return result;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    @Transactional
    public CmsCommentNotice getCommentNotice(Integer noticeID) throws Exception {
        try {
            CmsCommentNotice result = null;
            result = cmsCommentNoticeMapper.selectByPrimaryID(noticeID);
            
            if (result != null) {
                if(cmsCommentNoticeMapper.deleteByPrimaryKey(result.getNoticeID()) <= 0){
                    throw new Exception();
                }
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
}
