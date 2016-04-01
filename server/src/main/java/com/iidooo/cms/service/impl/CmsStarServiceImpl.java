package com.iidooo.cms.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iidooo.cms.mapper.CmsContentMapper;
import com.iidooo.cms.mapper.CmsStarMapper;
import com.iidooo.cms.model.po.CmsStar;
import com.iidooo.cms.service.CmsStarService;

@Service
public class CmsStarServiceImpl implements CmsStarService {

    private static final Logger logger = Logger.getLogger(CmsStarServiceImpl.class);

    @Autowired
    private CmsStarMapper cmsStarMapper;

    @Autowired
    private CmsContentMapper cmsContentMapper;

    @Override
    @Transactional
    public boolean starContent(Integer contentID, Integer createUserID) throws Exception {
        try {
            CmsStar cmsStar = cmsStarMapper.selectByUserContentID(contentID, createUserID);
            if (cmsStar == null) {
                // 第一次点赞
                cmsStar = new CmsStar();
                cmsStar.setContentID(contentID);
                cmsStar.setCreateTime(new Date());
                cmsStar.setCreateUserID(createUserID);
                cmsStar.setIsStar(1);
                cmsStar.setRemarks("");
                cmsStar.setUpdateTime(new Date());
                cmsStar.setUpdateUserID(createUserID);
                if (cmsStarMapper.insert(cmsStar) > 0) {
                    if(cmsContentMapper.updateStarCount(contentID, true) <= 0){
                        throw new Exception();
                    }
                } else {
                    return false;
                }
            } else {
                boolean isPlus = false;
                if (cmsStar.getIsStar() <= 0) {
                    // DB中的该条记录的点赞处于未点赞状态，那么就点赞更新
                    cmsStar.setIsStar(1);
                    isPlus = true;
                } else {
                    // DB中的该条记录的点赞处于点赞状态，那么就取消点赞
                    cmsStar.setIsStar(0);
                }
                if (cmsStarMapper.update(cmsStar) > 0) {
                    if(cmsContentMapper.updateStarCount(contentID, isPlus) <= 0){
                        throw new Exception();
                    }
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.fatal(e);
            throw e;
        }
    }

}
