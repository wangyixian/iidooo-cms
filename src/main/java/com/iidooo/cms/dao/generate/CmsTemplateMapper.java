package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsTemplate;

public interface CmsTemplateMapper {
    int deleteByPrimaryKey(Integer templateID);

    int insert(CmsTemplate record);

    int insertSelective(CmsTemplate record);

    CmsTemplate selectByPrimaryKey(Integer templateID);

    int updateByPrimaryKeySelective(CmsTemplate record);

    int updateByPrimaryKey(CmsTemplate record);
}