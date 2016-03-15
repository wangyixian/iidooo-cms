package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.core.model.Page;

public interface ContentService {
    List<CmsContentDto> getContentListByType(String channelPath, String contentType, Page page);
}
