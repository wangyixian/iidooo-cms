package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.Site;

public interface SiteMapper {
    int deleteByPrimaryKey(Integer siteID);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(Integer siteID);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
}