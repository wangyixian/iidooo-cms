package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsStatistics;

public interface CmsStatisticsMapper {
    int deleteByPrimaryKey(Integer statisticsID);

    int insert(CmsStatistics record);

    int insertSelective(CmsStatistics record);

    CmsStatistics selectByPrimaryKey(Integer statisticsID);

    int updateByPrimaryKeySelective(CmsStatistics record);

    int updateByPrimaryKey(CmsStatistics record);
}