package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.CmsChannel;

public interface CmsChannelMapper {
    int deleteByPrimaryKey(Integer channelID);

    int insert(CmsChannel record);

    int insertSelective(CmsChannel record);

    CmsChannel selectByPrimaryKey(Integer channelID);

    int updateByPrimaryKeySelective(CmsChannel record);

    int updateByPrimaryKey(CmsChannel record);
}