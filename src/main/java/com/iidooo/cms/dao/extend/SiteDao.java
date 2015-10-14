package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.SiteDto;
import com.iidooo.core.dto.extend.SecurityRoleDto;

public interface SiteDao {
    
    SiteDto selectBySiteID(int siteID); 
    
    List<SiteDto> selectAll();
    
    List<SiteDto> selectSiteListByRoles(@Param("roleList")List<SecurityRoleDto> roleList);
    
    SiteDto selectBySiteCode(String siteCode);
    
}
