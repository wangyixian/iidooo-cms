package com.iidooo.cms.service;

import java.util.HashMap;

import com.iidooo.cms.dto.extend.CmsBlockDto;
import com.iidooo.cms.dto.extend.CmsPageDto;

public interface PageService {
    CmsPageDto getPageByID(int pageID);
    
    HashMap<String, CmsBlockDto> getBlockMap(int pageID);
    
}
