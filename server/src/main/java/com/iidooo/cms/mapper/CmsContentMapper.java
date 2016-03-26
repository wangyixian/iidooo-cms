package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.core.model.Page;

public interface CmsContentMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContent record);

    int insertSelective(CmsContent record);

    CmsContent selectByPrimaryKey(Integer contentID);
    
    int updateByPrimaryKeySelective(CmsContent record);

    int updateByPrimaryKeyWithBLOBs(CmsContent record);

    int updateByPrimaryKey(CmsContent record);
    
    /**
     * 根据栏目路径查询获得内容一览
     * @param channelPath 限定的栏目路径
     * @param createUserID 指定内容创建者
     * @param page 分页对象
     * @return 内容一览List对象
     */
    List<CmsContent> selectContentListByChannelPath(@Param("channelPath")String channelPath, @Param("createUserID")Integer createUserID, @Param("page")Page page);

}