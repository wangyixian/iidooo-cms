package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.core.dto.PageDto;

public interface ContentDao {

    int selectCountBySiteID(int siteID);
    
    /**
     * Select content by content ID
     * @param contentID This content' ID will be selected
     * @return The selected ContentDto
     */
    ContentDto selectByContentID(int contentID);
    
    ContentDto selectOneContentByChannelPath(@Param("siteCode") String siteCode, @Param("channelPath") String channelPath);

    /**
     * Select all of the contents and get the record count
     * @return The record count.
     */
    int selectAllCount();
    
    /**
     * Select all of the contents with page
     * @param pageDto Do the page
     * @return The list of contents
     */
    List<ContentDto> selectAll(PageDto page);
    
    
    int selectContentListCount(ContentDto content);
    
    List<ContentDto> selectContentList(@Param("content")ContentDto content, @Param("page")PageDto page);
    
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
    
    
    
    
    List<ContentDto> selectContents(Map<String, Object> params);

    List<ContentDto> selectByChannelPath(@Param("siteCode") String siteCode, @Param("channelPath") String channelPath, @Param("page") PageDto page);

    int insert(ContentDto content);

    int update(ContentDto content);

    int delete(ContentDto content);
}
