package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;

public interface ContentService {
    CmsContentDto getContentByID(int contentID);
}
