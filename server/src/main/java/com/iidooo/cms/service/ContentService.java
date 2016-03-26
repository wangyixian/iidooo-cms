package com.iidooo.cms.service;

import java.util.List;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.core.model.Page;

public interface ContentService {
    List<CmsContent> getContentListByType(String channelPath, CmsContent cmsContent, Page page);
}
