package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsContentDto;

public interface CmsContentDao {
    List<CmsContentDto> selectContentsByPV(Map<String, Object> params);
    
    List<CmsContentDto> selectContentsByTag(Map<String, Object> params);
    
    CmsContentDto selectContentByID(int contentID);
}
