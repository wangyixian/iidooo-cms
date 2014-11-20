package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;

public interface ContentService {
    List<CmsContentDto> getCmsContents(String channelPath, String tag, String orderBy, String count);
}
