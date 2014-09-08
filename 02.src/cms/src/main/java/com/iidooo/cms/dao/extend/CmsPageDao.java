package com.iidooo.cms.dao.extend;

import com.iidooo.cms.dao.generate.CmsPageMapper;
import com.iidooo.cms.dto.extend.CmsPageDto;

public interface CmsPageDao extends CmsPageMapper{
    CmsPageDto selectByPageCode(String pageCode);
    
    CmsPageDto selectByPageID(int pageID);
}