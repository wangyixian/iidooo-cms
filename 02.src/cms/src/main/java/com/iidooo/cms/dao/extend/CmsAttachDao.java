package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsAttachDto;

public interface CmsAttachDao {
    List<CmsAttachDto> selectAttachsByAlbumID(int albumID);
}
