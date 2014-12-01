package com.iidooo.cms.dao.extend;

import java.util.List;
import java.util.Map;

import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;
import com.iidooo.cms.dto.generate.CmsAttachAlbum;

public interface CmsAttachAlbumDao {
    List<CmsAttachAlbumDto> selectAttachAlbums(Map<String, Object> params);
}