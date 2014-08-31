package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.generate.CmsBlock;

public interface CmsBlockDao {
    List<CmsBlock> selectByPageID(int pageID);
}