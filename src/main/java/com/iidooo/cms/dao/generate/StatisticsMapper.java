package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.Statistics;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer statisticsID);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer statisticsID);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}