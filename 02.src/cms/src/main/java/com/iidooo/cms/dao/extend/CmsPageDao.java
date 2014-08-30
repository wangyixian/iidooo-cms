package com.iidooo.cms.dao.extend;

import com.iidooo.cms.dao.generate.CmsPageMapper;
import com.iidooo.cms.dto.generate.CmsPage;

public interface CmsPageDao extends CmsPageMapper{
    CmsPage selectByPageName(String pageName);
}