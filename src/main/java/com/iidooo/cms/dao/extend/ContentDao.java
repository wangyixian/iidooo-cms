package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

public interface ContentDao {
    
    /**
     * Select content by content ID
     * @param contentID This content' ID will be selected
     * @return The selected ContentDto
     */
    ContentDto selectByContentID(int contentID);
    
    ContentDto selectOneContentByChannelPath(@Param("siteCode") String siteCode, @Param("channelPath") String channelPath);
            
    int selectContentListCount(@Param("siteID")int siteID, @Param("content")ContentDto content);
    
    List<ContentDto> selectContentList(@Param("siteID")int siteID, @Param("content")ContentDto content, @Param("page")PageDto page);
    
    /**
     * Get all of the channel contents's count
     * 
     * @param channels This list of channels' content will be gotten.
     * @return The count of result
     */
    int selectContentListCountByChannels(List<Integer> channels);

    /**
     * Get all of the channel contents
     * 
     * @param channels This list of channels' content will be gotten.
     * @param page Do page
     * @return The list of contents
     */
    List<ContentDto> selectContentListByChannels(@Param("channels") List<Integer> channels, @Param("page") PageDto page);
    
    List<ContentDto> selectByChannelPath(@Param("siteCode") String siteCode, @Param("channelPath") String channelPath, @Param("page") PageDto page);

    int insert(ContentDto content);

    int update(ContentDto content);

    int delete(ContentDto content);
}
