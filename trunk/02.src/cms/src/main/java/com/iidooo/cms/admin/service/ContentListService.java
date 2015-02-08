package com.iidooo.cms.admin.service;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ContentListService {
    int getChannelContentsCount(List<CmsChannelDto> channels);
    
    List<CmsContentDto> getChannelContents(List<CmsChannelDto> channels, PagingDto pagingDto);
}
