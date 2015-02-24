package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface CmsContentDao {
    List<CmsContentDto> selectContentsByPV(Map<String, Object> params);
    
    List<CmsContentDto> selectContentsByTag(Map<String, Object> params);
    
    List<CmsContentDto> selectContents(Map<String, Object> params);    
       
    /**
     * Get all of the channel contents's count
     * @param channels This list of channels' content will be gotten.
     * @return The count of result
     */
    int selectChannelContentsCount(List<CmsChannelDto> channels);
    
    /**
     * Get all of the channel contents
     * @param channels This list of channels' content will be gotten.
     * @param page Do page
     * @return The list of contents
     */
    List<CmsContentDto> selectChannelContents(@Param("channels")List<CmsChannelDto> channels, @Param("page")PagingDto page);
    
    CmsContentDto selectContentByID(int contentID);
    
    CmsContentDto selectByChannel(int channelID);
    
    int selectMaxSequence();
    
    int insert(CmsContentDto content);
    
    int updateByPrimaryKey(CmsContentDto content);
    
    int deleteByPrimaryKey(CmsContentDto content);
}
