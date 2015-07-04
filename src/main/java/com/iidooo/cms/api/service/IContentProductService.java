package com.iidooo.cms.api.service;

import java.util.List;

import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.dto.PageDto;

public interface IContentProductService {
    ContentProductDto getContentProduct(int contentID);
    
    int searchContentProductListSize(String siteCode, ContentProductDto product);
    
    List<ContentProductDto> searchContentProductList(String siteCode, ContentProductDto product, PageDto page);
}