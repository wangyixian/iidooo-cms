package com.iidooo.cms.service;

import com.iidooo.cms.dto.extend.CmsContentProductDto;

public interface ContentProductService {
    CmsContentProductDto getContentByID(int contentID);
}
