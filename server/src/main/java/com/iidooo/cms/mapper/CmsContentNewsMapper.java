package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.cms.model.po.CmsContentNews;
import com.iidooo.core.model.Page;

public interface CmsContentNewsMapper {
    int deleteByPrimaryKey(Integer contentID);

    /**
     * 插入新的新闻内容对象
     * @param contentNews 该新闻内容对象会被插入
     * @return 所影响的行数
     */
    int insert(CmsContentNews contentNews);

    /**
     * 根据内容ID获得新闻内容对象
     * @param contentID 通过该内容ID获得
     * @return 所获的的新闻内容对象
     */
    CmsContentNews selectByContentID(Integer contentID);

    int updateByPrimaryKeySelective(CmsContentNews record);

    int updateByPrimaryKey(CmsContentNews record);
    
    /**
     * 得到指定栏目下的内容一览
     * @param channelPath 栏目路径
     * @param cmsContent 指定内容的参数
     * @param page 分页对象
     * @return 内容一览List
     */
    List<CmsContent> selectContentNewsList(@Param("channelPath")String channelPath, @Param("cmsContent")CmsContent cmsContent, @Param("page")Page page);
}