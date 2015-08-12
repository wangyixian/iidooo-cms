package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.passport.dto.extend.RoleDto;

public interface SiteDao {
    
    SiteDto selectBySiteID(int siteID); 
    
    List<SiteDto> selectAll();
    
    List<SiteDto> selectSiteListByRoles(@Param("roleList")List<RoleDto> roleList);
    
    SiteDto selectBySiteCode(String siteCode);
    
    SiteDto selectTopSite();
}
