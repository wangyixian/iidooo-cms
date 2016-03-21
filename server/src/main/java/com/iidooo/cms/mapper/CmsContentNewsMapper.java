package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.core.model.Page;

public interface CmsContentNewsMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContentNews record);

    int insertSelective(CmsContentNews record);

    CmsContentNews selectByPrimaryKey(Integer contentID);

    int updateByPrimaryKeySelective(CmsContentNews record);

    int updateByPrimaryKey(CmsContentNews record);
    
    /**
     * 得到指定栏目下的内容一览
     * @param channelPath 栏目路径
     * @param page 分页对象
     * @return 内容一览List
     */
    List<CmsContent> selectContentNewsList(@Param("channelPath")String channelPath, @Param("page")Page page);
}