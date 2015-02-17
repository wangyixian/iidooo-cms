package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.CmsChannelDto;
import com.iidooo.cms.dto.extend.CmsContentProductDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface CmsContentProductDao {
    int selectProductsCount(@Param("channels")List<CmsChannelDto> channels, @Param("product")CmsContentProductDto product);

    List<CmsContentProductDto> selectProducts(@Param("channels")List<CmsChannelDto> channels, @Param("product")CmsContentProductDto product, @Param("page")PagingDto page);
}