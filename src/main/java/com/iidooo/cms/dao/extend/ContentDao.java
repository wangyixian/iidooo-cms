package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ContentDao {
    List<ContentDto> selectContentsByPV(Map<String, Object> params);
    
    List<ContentDto> selectContentsByTag(Map<String, Object> params);
    
    List<ContentDto> selectContents(Map<String, Object> params);    
       
    /**
     * Get all of the channel contents's count
     * @param channels This list of channels' content will be gotten.
     * @return The count of result
     */
    int selectChannelContentsCount(List<ChannelDto> channels);
    
    /**
     * Get all of the channel contents
     * @param channels This list of channels' content will be gotten.
     * @param page Do page
     * @return The list of contents
     */
    List<ContentDto> selectChannelContents(@Param("channels")List<ChannelDto> channels, @Param("page")PagingDto page);
    
    ContentDto selectContentByID(int contentID);
    
    ContentDto selectByChannel(int channelID);
    
    List<ContentDto> selectByChannelPath(@Param("channelPath")String channelPath, @Param("page")PagingDto page);
    
    int selectMaxSequence();
    
    int insert(ContentDto content);
    
    int updateByPrimaryKey(ContentDto content);
    
    int deleteByPrimaryKey(ContentDto content);
}
