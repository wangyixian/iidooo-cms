package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsFavorite;
import com.iidooo.cms.model.vo.CmsContentWrap;
import com.iidooo.core.model.Page;

public interface CmsFavoriteMapper {
    
    /**
     * 取消收藏，进行逻辑删除
     * @param cmsFavorite 取消收藏的对象
     * @return 所影响的行数
     */
    int deleteByUserContentID(CmsFavorite cmsFavorite);

    /**
     * 把内容加入用户收藏
     * @param cmsFavorite 加入收藏的插入对行
     * @return 所影响的行数
     */
    int insert(CmsFavorite cmsFavorite);
    
    /**
     * 通过用户ID，内容ID获得收藏对象
     * @param userID 用户ID
     * @param contentID 内容ID
     * @return 所获得的收藏对象
     */
    CmsFavorite selectByUserContentID(@Param("userID")Integer userID, @Param("contentID")Integer contentID);

    /**
     * 通过用户ID，获得该用户所有的收藏内容列表
     * @param userID 用户ID
     * @param page 分页对象
     * @return CmsContentWrap 列表
     */
    List<CmsContentWrap> selectByUserID(@Param("userID")Integer userID,@Param("page") Page page);
    
    /**
     * 根据用户ID获得所有的收藏一览
     * @param userID 用户ID
     * @return Favorite的List
     */
    List<CmsFavorite> selectFavoriteList(Integer userID);

    int updateByPrimaryKeySelective(CmsFavorite record);

    int updateByPrimaryKey(CmsFavorite record);
}