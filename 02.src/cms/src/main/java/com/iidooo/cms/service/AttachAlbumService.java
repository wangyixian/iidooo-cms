package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsAttachAlbumDto;
import com.iidooo.cms.dto.extend.CmsAttachDto;

public interface AttachAlbumService {
    CmsAttachAlbumDto getAttachAlbumDto(int albumID);
}
