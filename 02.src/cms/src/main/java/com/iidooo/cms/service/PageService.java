package com.iidooo.cms.service;

import com.iidooo.cms.dto.generate.CmsPage;

public interface PageService {
    CmsPage getPageByName(String pageName);
}
