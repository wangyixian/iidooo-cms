package com.iidooo.cms.admin.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.extend.FieldDataDto;

public interface ContentDetailService {
    boolean createContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos);
    
    boolean updateContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos);
    
    boolean deleteContent(int userID, CmsContentDto content, List<FieldDataDto> fieldDataDtos);
}
