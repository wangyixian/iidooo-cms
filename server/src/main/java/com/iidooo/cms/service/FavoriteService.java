package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.vo.CmsContentWrap;
import com.iidooo.core.model.Page;


public interface FavoriteService {
    Integer addFavorite(Integer userID, Integer contentID);
    
    boolean removeFavorite(Integer userID, Integer contentID);
    
    List<CmsContentWrap> getFavoriteContentList(Integer userID, Page page);
}
