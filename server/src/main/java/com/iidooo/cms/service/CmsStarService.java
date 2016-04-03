package com.iidooo.cms.service;

import com.iidooo.cms.model.po.CmsStar;


public interface CmsStarService {
    CmsStar starContent(Integer contentID, Integer createUserID) throws Exception;
    
    CmsStar unstarContent(Integer contentID, Integer createUserID) throws Exception;
}
