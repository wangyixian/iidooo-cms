package com.iidooo.cms.admin.service.content;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ContentListService {
    int getAllContentsCount();
    
    List<CmsContentDto> getAllContents(PagingDto pagingDto);
}
