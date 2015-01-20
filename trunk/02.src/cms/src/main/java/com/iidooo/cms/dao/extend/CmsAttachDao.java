package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsAttachDto;

public interface CmsAttachDao {
    List<CmsAttachDto> selectAttachs(Map<String, Object> params);
    
    List<CmsAttachDto> selectAttachsByAlbumID(int albumID);
    
    CmsAttachDto selectAttachByID(int attachID);
}
