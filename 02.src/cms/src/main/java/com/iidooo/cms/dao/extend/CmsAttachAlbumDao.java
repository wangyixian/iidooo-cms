package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;

public interface CmsAttachAlbumDao {
    List<CmsAttachAlbumDto> selectAttachAlbums(Map<String, Object> params);
    
    CmsAttachAlbumDto selectAttachAlbumByID(int albumID);
    
    List<CmsAttachAlbumDto> selectAttachAlbumsByClassify(CmsAttachAlbumDto albumDto);
}