package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.ChannelContent;

public interface ChannelContentMapper {
    int deleteByPrimaryKey(Integer channelContentID);

    int insert(ChannelContent record);

    int insertSelective(ChannelContent record);

    ChannelContent selectByPrimaryKey(Integer channelContentID);

    int updateByPrimaryKeySelective(ChannelContent record);

    int updateByPrimaryKey(ChannelContent record);
}