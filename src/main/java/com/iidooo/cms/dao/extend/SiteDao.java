package com.iidooo.cms.dao.extend;

import com.iidooo.cms.dto.extend.SiteDto;

public interface SiteDao {
    
    SiteDto selectBySiteCode(String siteCode);
    
}
