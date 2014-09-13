package com.iidooo.cms.dao.extend;

import com.iidooo.cms.dao.generate.CmsArticleMapper;
import com.iidooo.cms.dto.extend.CmsArticleDto;

public interface CmsArticleDao extends CmsArticleMapper {
    CmsArticleDto selectByPageID(int pageID);
}