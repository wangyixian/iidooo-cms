package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.SiteRole;

public interface SiteRoleMapper {
    int deleteByPrimaryKey(Integer siteRoleID);

    int insert(SiteRole record);

    int insertSelective(SiteRole record);

    SiteRole selectByPrimaryKey(Integer siteRoleID);

    int updateByPrimaryKeySelective(SiteRole record);

    int updateByPrimaryKey(SiteRole record);
}