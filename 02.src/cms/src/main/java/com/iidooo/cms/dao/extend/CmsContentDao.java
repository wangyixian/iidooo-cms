package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface CmsContentDao {
    List<CmsContentDto> selectContentsByPV(Map<String, Object> params);
    
    List<CmsContentDto> selectContentsByTag(Map<String, Object> params);
    
    List<CmsContentDto> selectContents(Map<String, Object> params);
    
    
    /**
     * Get all of the contents
     * @return The list of CmsContentDto
     */
    List<CmsContentDto> selectAll(PagingDto pagingDto);
    
    /**
     * Get the count of all contents
     * @return The count
     */
    int selectAllCount();
    
    CmsContentDto selectContentByID(int contentID);
}
