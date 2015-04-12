package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsUser;

public interface CmsUserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(CmsUser record);

    int insertSelective(CmsUser record);

    CmsUser selectByPrimaryKey(Integer userID);

    int updateByPrimaryKeySelective(CmsUser record);

    int updateByPrimaryKey(CmsUser record);
}