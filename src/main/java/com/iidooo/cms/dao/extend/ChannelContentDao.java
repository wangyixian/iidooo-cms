package com.iidooo.cms.dao.extend;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ChannelContentDto;

public interface ChannelContentDao {
    
    int selectContentCount(Integer contentID);
    
    int insert(ChannelContentDto channelContent);
    
    int updateByChannelID(@Param("channelContent")ChannelContentDto channelContent, @Param("oldChannelID")Integer oldChannelID);
    
    int deleteContent(@Param("channelID")Integer channelID, @Param("contentID")Integer contentID);
}
