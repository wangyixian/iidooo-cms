package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsBlockDto;

public interface CmsBlockDao {
    List<CmsBlockDto> selectByPageID(int pageID);
}