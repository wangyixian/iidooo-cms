package com.iidooo.passport.dao.generate;

import com.iidooo.passport.dto.generate.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceID);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceID);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}