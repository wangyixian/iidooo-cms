package com.iidooo.cms.dao.generate;

import com.iidooo.cms.dto.generate.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer channelID);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer channelID);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}