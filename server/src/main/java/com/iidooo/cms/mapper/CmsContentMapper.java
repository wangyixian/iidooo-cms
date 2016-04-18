package com.iidooo.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.CmsContent;
import com.iidooo.core.model.Page;

public interface CmsContentMapper {
    int deleteByPrimaryKey(Integer contentID);

    int insert(CmsContent content);

    /**
     * 根据ContentID查询获得内容对象
     * @param contentID 通过该内容ID查询
     * @return 所获得的内容对象
     */
    CmsContent selectByContentID(Integer contentID);
    
    /**
     * 获得指定用户的内容数
     * @param userID 指定用户的ID
     * @return 返回的内容数
     */
    int selectCountByUserID(Integer userID);
    
    /**
     * 根据栏目路径查询获得内容一览
     * @param channelPath 限定的栏目路径
     * @param createUserID 指定内容创建者
     * @param page 分页对象
     * @return 内容一览List对象
     */
    List<CmsContent> selectContentListByChannelPath(@Param("channelPath")String channelPath, @Param("createUserID")Integer createUserID, @Param("page")Page page);
    
    /**
     * 得到内容的点赞数
     * @param contentID 该内容ID的点赞数
     * @return 点赞数
     */
    int selectStarCount(Integer contentID);
    
    /**
     * 根据ContentID更新CmsContent
     * @param cmsContnt 该对象的数据会被更新进数据库
     * @return 更新影响到的行数
     */
    int updateByContentID(CmsContent cmsContnt);
        
    /**
     * 更新内容的PV和UV
     * @param contentID 该内容的PV，UV会被更新
     * @param pvCount PV数量
     * @param uvCount UV数量
     * @return 更新所影响的行数
     */
    int updateViewCount(@Param("contentID")Integer contentID, @Param("pvCount")Integer pvCount, @Param("uvCount")Integer uvCount);

    /**
     * 更新内容的评论数
     * @param contentID 指定内容ID
     * @param commentCount 评论数
     * @return 更新所影响的行数
     */
    int updateCommentCount(@Param("contentID")Integer contentID, @Param("commentCount") Integer commentCount);
    
    /**
     * 更新内容的点赞总数
     * @param contentID 指定内容ID
     * @param isPlus 是否是增加赞的标识
     * @return 更新所影响的行数
     */
    int updateStarCount(@Param("contentID")Integer contentID, @Param("isPlus")boolean isPlus);
    
    int updateByPrimaryKey(CmsContent record);
    
    
}