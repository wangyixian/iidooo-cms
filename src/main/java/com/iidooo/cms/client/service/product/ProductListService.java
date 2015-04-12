package com.iidooo.cms.client.service.product;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ProductListService {
    int searchCount(List<CmsChannelDto> channels, CmsContentProductDto product);

    List<CmsContentProductDto> search(List<CmsChannelDto> channels, CmsContentProductDto product, PagingDto page);
}
