package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.CmsChannel;

public interface CmsChannelMapper {
    int deleteByPrimaryKey(Integer channelID);

    int insert(CmsChannel record);

    int insertSelective(CmsChannel record);

    CmsChannel selectByPrimaryKey(Integer channelID);

    int updateByPrimaryKeySelective(CmsChannel record);

    int updateByPrimaryKey(CmsChannel record);
}