package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.dto.PageDto;

public interface ContentProductDao {
    int selectProductsCount(@Param("channels")List<ChannelDto> channels, @Param("product")ContentProductDto product);

    List<ContentProductDto> selectProducts(@Param("channels")List<ChannelDto> channels, @Param("product")ContentProductDto product, @Param("page")PageDto page);

    ContentProductDto selectByContentID(int contentID);
    
    int insert(ContentProductDto product);
    
    int updateByPrimaryKey(ContentProductDto product);
}