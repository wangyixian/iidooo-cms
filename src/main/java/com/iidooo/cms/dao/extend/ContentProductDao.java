package com.iidooo.cms.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.core.dto.PageDto;

public interface ContentProductDao {
    
    /**
     * Select the Product type of content by the content ID 
     * @param contentID This content ID's product will be selected
     * @return The selected ContentProductDto
     */
    ContentProductDto selectByContentID(int contentID);
    
    int selectProductListSize(@Param("siteCode")String siteCode, @Param("channels")List<Integer> channels, @Param("product")ContentProductDto product);

    List<ContentProductDto> selectProductList(@Param("siteCode")String siteCode, @Param("channels")List<Integer> channels, @Param("product")ContentProductDto product, @Param("page")PageDto page);

    
    int insert(ContentProductDto product);
    
    int updateByPrimaryKey(ContentProductDto product);
}