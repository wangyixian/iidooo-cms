package com.iidooo.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.mapper.CmsFavoriteMapper;
import com.iidooo.cms.model.po.CmsFavorite;
import com.iidooo.cms.model.vo.CmsContentWrap;
import com.iidooo.cms.service.FavoriteService;
import com.iidooo.core.model.Page;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private static final Logger logger = Logger.getLogger(FavoriteServiceImpl.class);

    @Autowired
    private CmsFavoriteMapper favoriteMapper;

    @Override
    public Integer addFavorite(Integer userID, Integer contentID) {
        try {
            CmsFavorite cmsFavorite = favoriteMapper.selectByUserContentID(userID, contentID);
            if (cmsFavorite != null) {
                return cmsFavorite.getFavoriteID();
            } else {
                cmsFavorite = new CmsFavorite();
                cmsFavorite.setUserID(userID);
                cmsFavorite.setContentID(contentID);
                cmsFavorite.setCreateTime(new Date());
                cmsFavorite.setCreateUserID(userID);
                cmsFavorite.setUpdateTime(new Date());
                cmsFavorite.setUpdateUserID(userID);

                if (favoriteMapper.insert(cmsFavorite) > 0) {
                    return cmsFavorite.getFavoriteID();
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public Integer removeFavorite(Integer userID, Integer contentID) {
        try {

            CmsFavorite cmsFavorite = favoriteMapper.selectByUserContentID(userID, contentID);
            if (cmsFavorite != null) {
                cmsFavorite.setUpdateTime(new Date());
                cmsFavorite.setUpdateUserID(userID);
                favoriteMapper.deleteByUserContentID(cmsFavorite);
                return cmsFavorite.getFavoriteID();
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public List<CmsContentWrap> getFavoriteContentList(Integer userID, Page page) {
        try {
            List<CmsContentWrap> result = favoriteMapper.selectByUserID(userID, page);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }

    @Override
    public List<CmsFavorite> getFavoriteList(Integer userID) {
        try {
            List<CmsFavorite> result = favoriteMapper.selectFavoriteList(userID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            throw e;
        }
    }
    
    

}
