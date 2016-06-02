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
     * 
     * @param contentID 通过该内容ID查询
     * @return 所获得的内容对象
     */
    CmsContent selectByContentID(Integer contentID);
    
    /**
     * 为了防止前台的重复提交问题，增加了该方法，提交前确认一下是否有同样的数据存在
     * @param createUserID 创建者ID
     * @param contentType 内容类型
     * @param contentBody 内容体
     * @return 所获得内容对象
     */
    CmsContent selectByContentInfo(@Param("createUserID")Integer createUserID, @Param("contentType")String contentType, @Param("contentBody")String contentBody);

    /**
     * 获得指定用户的内容数
     * 
     * @param userID 指定用户的ID
     * @param contentType 统计的内容类型
     * @return 返回的内容数
     */
    int selectCountByUserID(@Param("userID")Integer userID, @Param("contentType")String contentType);

    /**
     * 根据栏目路径查询获得内容一览
     * 
     * @param channelPath 限定的栏目路径
     * @param cmsContent 指定内容的参数
     * @param page 分页对象
     * @return 内容一览List对象
     */
    List<CmsContent> selectContentListByChannelPath(@Param("channelPath") String channelPath, @Param("cmsContent") CmsContent cmsContent,
            @Param("page") Page page);
        
    /**
     * 毒电波用的Tab2自媒体一览
     * @param cmsContent 指定内容的参数
     * @param page 分页显示对象
     * @return 内容一览List
     */
    List<CmsContent> selectContentListForToxicWaveTab2(@Param("cmsContent")CmsContent cmsContent, @Param("page") Page page);
    
    /**
     * 得到内容的点赞数
     * 
     * @param contentID 该内容ID的点赞数
     * @return 点赞数
     */
    int selectStarCount(Integer contentID);

    /**
     * 得到所有内容的PV
     * 
     * @return PV总数量
     */
    int selectPVCountSum();

    /**
     * 检索内容一览信息的数量
     * @param cmsContent 检索的条件封装
     * @param startDate 内容发布开始日期
     * @param endDate 内容发布结束日期
     * @return 得到的内容一览列表
     */
    int selectCountForSearch(@Param("cmsContent") CmsContent cmsContent, @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 检索内容一览信息
     * 
     * @param cmsContent 检索的条件封装
     * @param startDate 内容发布开始日期
     * @param endDate 内容发布结束日期
     * @return 得到的内容一览列表
     */
    List<CmsContent> selectForSearch(@Param("cmsContent") CmsContent cmsContent, @Param("startDate") String startDate, @Param("endDate") String endDate,
            @Param("page") Page page);

    /**
     * 根据ContentID更新CmsContent
     * 
     * @param cmsContnt 该对象的数据会被更新进数据库
     * @return 更新影响到的行数
     */
    int updateByContentID(CmsContent cmsContnt);

    /**
     * 更新内容的PV和UV
     * 
     * @param contentID 该内容的PV，UV会被更新
     * @param pvCount PV数量
     * @param uvCount UV数量
     * @return 更新所影响的行数
     */
    int updateViewCount(@Param("contentID") Integer contentID, @Param("pvCount") Integer pvCount, @Param("uvCount") Integer uvCount);

    /**
     * 更新内容的评论数
     * 
     * @param contentID 指定内容ID
     * @param commentCount 评论数
     * @return 更新所影响的行数
     */
    int updateCommentCount(@Param("contentID") Integer contentID, @Param("commentCount") Integer commentCount);

    /**
     * 更新内容的点赞总数
     * 
     * @param contentID 指定内容ID
     * @param isPlus 是否是增加赞的标识
     * @return 更新所影响的行数
     */
    int updateStarCount(@Param("contentID") Integer contentID, @Param("isPlus") boolean isPlus);

    /**
     * 删除指定内容
     * @param content 该内容会被删除
     * @return 所影响的行数
     */
    int deleteByContentID(CmsContent content);
}