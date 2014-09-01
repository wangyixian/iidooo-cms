package com.iidooo.cms.service;

import java.util.HashMap;

import com.iidooo.cms.dto.extend.CmsBlockDto;
import com.iidooo.cms.dto.generate.CmsPage;

public interface PageService {
    CmsPage getPageByName(String pageName);
    
    HashMap<String, CmsBlockDto> getBlockMap(int pageID);
    
    String getSiteAddress();
}
