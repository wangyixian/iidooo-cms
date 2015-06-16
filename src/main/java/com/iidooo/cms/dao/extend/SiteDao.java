package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.SiteDto;

public interface SiteDao {
    
    List<SiteDto> selectAll();
    
    SiteDto selectBySiteCode(String siteCode);
    
}
