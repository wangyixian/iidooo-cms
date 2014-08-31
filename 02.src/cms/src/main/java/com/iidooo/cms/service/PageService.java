package com.iidooo.cms.service;

import java.util.HashMap;

import com.iidooo.cms.dto.generate.CmsBlock;
import com.iidooo.cms.dto.generate.CmsPage;

public interface PageService {
    CmsPage getPageByName(String pageName);
    
    HashMap<String, CmsBlock> getBlockMap(int pageID);
}
